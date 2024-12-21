package com.example.demo.jobPosting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/jobPosting")
public class JobPostingController {

	@Autowired
	private final JobPostingDAO dao;

	public JobPostingController() {
		this.dao = new JobPostingDAO();
	}

	@GetMapping
	public String showJobPosting() {
		return "jobPosting";
	}

	@PostMapping
	public String addJobPosting(JobPosting job, HttpSession session, Model model) {
		try {
			// 세션에서 로그인한 사용자의 userId 가져오기
			String employerId = (String) session.getAttribute("userId");

			if (employerId == null) {
				model.addAttribute("error", "로그인이 필요합니다.");
				return "redirect:/login";
			}
			
			// DAO에서 employer_id에 매칭되는 회사명 가져오기
	        String companyName = dao.getCompanyNameByEmployerId(employerId);
	        if (companyName == null) {
	            model.addAttribute("error", "회원 정보에서 회사명을 찾을 수 없습니다.");
	            return "jobPosting";
	        }

			// DAO로 고용주의 userId 전달
			job.setEmployer_id(employerId);
			dao.addJobPosting(job);

			return "redirect:/main";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "채용 공고 등록에 실패했습니다.");
			return "jobPosting";
		}
	}

	@PostMapping("/rate")
	public String rateJobPosting(@RequestParam("employPostNo") int employPostNo, @RequestParam("rating") int rating,
			Model model) {
		try {
			if (rating < 1 || rating > 5) {
				model.addAttribute("error", "평점은 1과 5 사이의 값이어야 합니다.");
				return "jobPostingDetail";
			}
			dao.updateRating(employPostNo, rating);
			model.addAttribute("message", "평점이 성공적으로 업데이트되었습니다.");
			return "redirect:/jobPosting/Detail?id=" + employPostNo;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "평점 업데이트에 실패했습니다.");
			return "jobPostingDetail";
		}
	}

	@GetMapping("/Detail")
	public String getJobPostingDetail(@RequestParam("id") int employPostNo, Model model) {
	    try {
	        System.out.println("Fetching details for employPostNo: " + employPostNo);

	        JobPosting job = dao.getJobPostingDetail(employPostNo);
	        if (job != null) {
	            String employerId = dao.getEmployerIdByEmployPostNo(employPostNo);
	            System.out.println("Employer ID: " + employerId);

	            if (employerId != null) {
	                job.setEmployer_id(employerId);

	                String companyName = dao.getCompanyNameByEmployerId(employerId);
	                System.out.println("Company Name: " + companyName);

	                job.setComName(companyName); // 회사명 설정
	            }
	            model.addAttribute("job", job);
	            return "jobPostingDetail";
	        } else {
	            model.addAttribute("error", "채용 공고를 찾을 수 없습니다.");
	            return "jobPostingList";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("error", "채용 공고 상세 정보를 로드하는 중 오류가 발생했습니다.");
	        return "jobPostingList";
	    }
	}
	@GetMapping("/List")
	public String getAllJobPostings(Model model) {
		try {
			List<JobPosting> jobList = dao.getAllJobPostings();
			model.addAttribute("jobList", jobList);
			return "jobPostingList";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "채용 공고 목록을 로드하는 중 오류가 발생했습니다.");
			return "jobPostingList";
		}
	}
	@GetMapping("/member/companyName")
	public @ResponseBody String getCompanyName(HttpSession session) {
	    try {
	        String employerId = (String) session.getAttribute("userId");
	        if (employerId != null) {
	            return dao.getCompanyNameByEmployerId(employerId);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "";
	}
}