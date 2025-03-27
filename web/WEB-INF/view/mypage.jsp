<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>마이페이지</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<!-- 네비게이션 -->
<nav class="bg-blue-500 text-white p-4 flex justify-between">
  <a href="/list" class="font-bold">게시판</a>
  <div>
    <a href="/login" class="mr-4">로그인</a>
    <a href="/register">회원가입</a>
  </div>
</nav>

<!-- 마이페이지 내용 -->
<div class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-lg mt-6">
  <h1 class="text-2xl font-bold mb-4 text-center">마이페이지</h1>

  <!-- 회원 정보 표시 -->
  <div class="mb-4">
    <p class="text-gray-700"><strong>아이디:</strong> user123</p>
    <p class="text-gray-700"><strong>이름:</strong> 홍길동</p>
    <p class="text-gray-700"><strong>성별:</strong> 남성</p>
    <p class="text-gray-700"><strong>나이:</strong> 25</p>
    <p class="text-gray-700"><strong>생년월일:</strong> 2000-01-01</p>
    <p class="text-gray-700"><strong>전화번호:</strong> 010-1234-5678</p>
    <p class="text-gray-700"><strong>가입일:</strong> 2025-03-26</p>
  </div>

  <!-- 비밀번호 확인 폼 -->
  <form action="/verify-password" method="post">
    <!-- Password -->
    <input type="password" id="password" name="pwd" placeholder="비밀번호 입력"
           class="w-full p-2 border rounded mb-4" required>

    <!-- Submit Button -->
    <button type="submit" class="w-full bg-green-500 text-white p-2 rounded hover:bg-green-700">정보 수정 페이지로 이동</button>
  </form>
</div>

</body>
</html>
