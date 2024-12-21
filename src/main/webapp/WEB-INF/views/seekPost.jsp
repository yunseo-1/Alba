<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구직글 작성</title>
    <style>

        h1 {
            text-align: center;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background: #f9f9f9;
        }
        .buttonC{
            display: flex;
            justify-content: center;
            margin: 15px;
            margin-left: 20px;
        }
        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: inline-block;
        }
        input[type="checkbox"] {
            display: none;
        }
        input[type="text"], select, button {
            width: calc(100% - 24px);
            padding: 13px;
            margin-bottom: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        .regionBox select, .jobTypeBox select{
            width: 100%;
            padding: 13px;
            border: 1px solid #ddd; 
            border-radius: 4px; 
            font-size: 14px; 
            box-sizing: border-box;
        }
        .checkPeriod ul {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            padding: 0;
            list-style: none;
        }
        .checkPeriod li {
            list-style: none;
        }
        .checkPeriod label {
            display: flex;
            padding: 13px 18px;
            justify-content: center;
            align-items: center;
            border-radius: 6px;
            border: 1px solid #DBDBDB;
            background: #FFF;
            cursor: pointer;
        }
        .checkPeriod input[type="checkbox"]:checked+label {
            border: 1px solid #FF9254;
            background: #FFF1E9;
        }
        button {
            background-color: #FF9254;+
            
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            border: none;
            border-radius: 20px;
        }
        button:hover {
            background-color: #FF7634;
        }
    </style>
</head>

<body>
    <h1>구직글 작성</h1>

    <form action="/jobSeeking" method="post"> <!-- Correct action URL here -->
        <div class="container">

            <label for="seekPostTitle">제목</label>
            <input type="text" id="seekPostTitle" name="seekPostTitle" placeholder="제목을 입력하세요" required>

            <label>희망 근무 기간</label>
            <div class="checkPeriod">
                <ul>
                    <li>
                        <input type="checkbox" value="1mon" name="wPeriod" id="1mon" onclick="selectOnlyOne(this)">
                        <label for="1mon">1개월</label>
                    </li>
                    <li>
                        <input type="checkbox" value="3mon" name="wPeriod" id="3mon" onclick="selectOnlyOne(this)">
                        <label for="3mon">3개월</label>
                    </li>
                    <li>
                        <input type="checkbox" value="6mon" name="wPeriod" id="6mon" onclick="selectOnlyOne(this)">
                        <label for="6mon">6개월</label>
                    </li>
                    <li>
                        <input type="checkbox" value="1year" name="wPeriod" id="1year" onclick="selectOnlyOne(this)">
                        <label for="1year">1년 이상</label>
                    </li>
                </ul>
            </div>

            <label for="region">희망 지역</label>
            <div class="regionBox">
                <select name="region" id="region"> <!-- Add name attribute here -->
                    <option value="1">정왕1동</option>
                    <option value="2">정왕2동</option>
                    <option value="3">정왕3동</option>
                    <option value="4">정왕4동</option>
                    <option value="5">정왕동</option>
                    <option value="6">정왕본동</option>
                </select>
            </div>

            <label for="jobType">희망 업종</label>
            <div class="jobTypeBox">
                <select name="jobType" id="jobType"> <!-- Add name attribute here -->
                    <option value="1">카페</option>
                    <option value="2">음식점</option>
                    <option value="3">편의점</option>
                    <option value="4">물류</option>
                    <option value="5">학원 강사</option>
                </select>
            </div>

            <div class="buttonC">
                <button type="submit">작성 완료</button>
            </div>

        </div>
    </form>

    <script>
        // checkbox 하나만 선택
        function selectOnlyOne(checkbox) {
            const checkboxes = document.querySelectorAll('input[name="wPeriod"]');
            checkboxes.forEach((item) => {
                if (item !== checkbox) {
                    item.checked = false;
                }
            });
        }
    </script>
</body>

</html>