package com.example.demo.jobSeeking;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/jobSeeking")
public class JobSeekingController {
	private final JobSeekingDAO dao;

	public JobSeekingController() {
		this.dao = new JobSeekingDAO();
	}

	@GetMapping
	public String showJobSeeking() {
		return "seekPost";
	}

	@PostMapping
	public String addJobSeeking(JobSeeking job, HttpSession session, Model model) {
		try {
			// 디버깅: wPeriod 값 확인
	        System.out.println("Received wPeriod: " + job.getwPeriod());
			// 세션에서 로그인한 사용자의 userId 가져오기
			String jobseekerId = (String) session.getAttribute("userId");

			if (jobseekerId == null) {
				model.addAttribute("error", "로그인이 필요합니다.");
				return "redirect:/login";
			}

			// JobSeeking 객체에 jobseeker_id 설정
			job.setJobseeker_id(jobseekerId);

			// DAO로 JobSeeking 객체 전달
			dao.addJobSeeking(job);

			return "redirect:/jobSeeking/List";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "구직글 등록에 실패했습니다.");
			return "seekPost";
		}
	}

	@GetMapping("/List")
	public String getAllJobSeekings(Model model) {
		try {
			List<JobSeeking> jobList = dao.getAllJobSeekings(); // 모든 구직글 조회
			model.addAttribute("jobList", jobList); // 모델에 데이터 추가
			return "jobSeekingList"; // 뷰 파일 이름 반환
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "구직글 목록을 로드하는 중 오류가 발생했습니다.");
			return "jobSeekingList"; // 오류 발생 시에도 같은 뷰 반환
		}
	}

	@GetMapping("/Detail")
	public String getJobSeekingDetail(@RequestParam("id") int seekPostNo, Model model) {
		try {
			JobSeeking job = dao.getJobSeekingDetail(seekPostNo);
			if (job != null) {
				System.out.println("JobSeeker ID from job object: " + job.getJobseeker_id());
				
				// jobSeeker_id를 이용하여 닉네임 가져오기
				String nickName = dao.getNickNameByJobSeekerId(job.getJobseeker_id());
				System.out.println("NickName fetched from database: " + nickName);
				// 기타 데이터 매핑
				job.setwPeriod(workPeriod(job.getwPeriod()));
				job.setRegion(mapRegion(job.getRegion()));
				job.setJobType(mapJobType(job.getJobType()));

				model.addAttribute("job", job);
				model.addAttribute("nickName", nickName); // 닉네임 추가
				return "jobSeekingDetail";
			} else {
				model.addAttribute("error", "구직글을 찾을 수 없습니다.");
				return "jobSeekingList";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "구직글 상세 정보를 로드하는 중 오류가 발생했습니다.");
			return "jobSeekingList";
		}
	}

	private String workPeriod(String periodId) {
		switch (periodId) {
		case "1mon":
			return "1개월";
		case "3mon":
			return "3개월";
		case "6mon":
			return "6개월";
		case "1year":
			return "1년 이상";
		default:
			return "Unknown period";
		}
	}

	private String mapRegion(String regionId) {
		switch (regionId) {
		case "1":
			return "정왕1동";
		case "2":
			return "정왕2동";
		case "3":
			return "정왕3동";
		case "4":
			return "정왕4동";
		case "5":
			return "정왕동";
		case "6":
			return "정왕본동";
		default:
			return "Unknown Region";
		}
	}

	private String mapJobType(String jobTypeId) {
		switch (jobTypeId) {
		case "1":
			return "카페";
		case "2":
			return "음식점";
		case "3":
			return "편의점";
		case "4":
			return "물류";
		case "5":
			return "학원 강사";
		default:
			return "Unknown Job Type";
		}
	}
}