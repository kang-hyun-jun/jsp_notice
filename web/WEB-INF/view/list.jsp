<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<!-- 네비게이션 -->
<nav class="bg-blue-500 text-white p-4 flex justify-between">
    <a href="list?f=&s=&p=" class="font-bold">게시판</a>
    <div>
        <a href="/login" class="mr-4">로그인</a>
        <a href="/register">회원가입</a>
    </div>
</nav>

<!-- 컨텐츠 -->
<div class="max-w-4xl mx-auto py-10 px-4">
    <h1 class="text-3xl font-bold mb-6">📋 게시판 목록</h1>

    <!-- 검색 폼 -->
    <form action="/list" method="get" class="mb-6 bg-white p-4 rounded-lg shadow-md">
        <div class="flex space-x-4 items-center">
            <!-- 검색 기준 선택 -->
            <select name="f" class="border rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-300">
                <option value="TITLE" ${(param.f.equals("TITLE")) ? "selected": ""}>제목</option>
                <option value="CONTENT" ${(param.f.equals("CONTENT")) ? "selected": ""}>내용</option>
                <option value="WRITER_ID" ${(param.f.equals("WRITER_ID")) ? "selected": ""}>작성자</option>
            </select>

            <!-- 검색어 입력 -->
            <input type="text" name="s" placeholder="검색어를 입력하세요" value="${(empty param.s) ? "":param.s}"
                    class="flex-grow border rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-300" required>

            <!-- 검색 버튼 -->
            <button type="submit"
                    class="bg-blue-500 hover:bg-blue-600 text-white px-5 py-2 rounded shadow-md transition duration-200 ease-in-out">
                검색
            </button>
        </div>
    </form>

    <!-- 게시글 테이블 -->
    <table class="w-full bg-white rounded shadow-md mb-4">
        <thead class="bg-blue-500 text-white">
        <tr>
            <th class="px-4 py-2">번호</th>
            <th class="px-4 py-2">제목</th>
            <th class="px-4 py-2">작성자</th>
            <th class="px-4 py-2">작성일</th>
            <th class="px-4 py-2">조회수</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <!-- 예시 게시글 -->
    <c:forEach var="n" items="${notices}" varStatus="st">
        <tr class="border-b hover:bg-gray-100">
            <td class="px-4 py-2">${n.id}</td>
            <td class="px-4 py-2 text-left"><a href="detail?id=${n.id}" class="text-blue-600 hover:underline">${n.title}</a></td>
            <td class="px-4 py-2">${n.writer_id}</td>
            <td class="px-4 py-2">${n.regdate}</td>
            <td class="px-4 py-2">${n.hit}</td>
        </tr>
    </c:forEach>
        <!-- 추가 게시글을 동일한 형식으로 추가 -->
        </tbody>
    </table>

    <!-- 페이징 번호 -->
    <div class="flex justify-center space-x-2 mb-6">
        <c:set var="page" value="${(empty param.p) ? 1:param.p}"/>
        <c:set var="startPage" value="${page-(page-1)%5}"/>
        <c:set var="lastPage" value="${(empty count) ? 1 : count}"/>
        <c:if test="${(startPage-5)>=1}">
            <a href="?p=${startPage-5}&f=${param.f}&s=${param.s}" class="px-3 py-1 bg-gray-300 rounded hover:bg-gray-400"><</a>
        </c:if>
        <c:if test="${(startPage-5)<1}">
            <span class="px-3 py-1 bg-gray-300 rounded hover:bg-gray-400" onclick="alert('이전 페이지가 없습니다.');"><</span>
        </c:if>
        <c:forEach var="i" begin="0" end="4" varStatus="st">
            <c:if test="${i+startPage>count}">
                <span class="px-3 py-1 bg-gray-300 rounded hover:bg-gray-400" onclick="alert('해당 페이지가 없습니다.');">${startPage+i}</span>
            </c:if>
            <c:if test="${i+startPage<=count}">
                <a href="?p=${startPage+i}&f=${param.f}&s=${param.s}" class="px-3 py-1 rounded hover:bg-gray-400 ${(page==startPage+i)? "bg-blue-500 text-white" : "bg-gray-300"}">${startPage+i}</a>
            </c:if>
        </c:forEach>

        <c:if test="${(startPage+5)<=lastPage}">
            <a href="?p=${page+5}" class="px-3 py-1 bg-gray-300 rounded hover:bg-gray-400">></a>
        </c:if>
        <c:if test="${(startPage+5)>lastPage}">
            <span class="px-3 py-1 bg-gray-300 rounded hover:bg-gray-400" onclick="alert('다음 페이지가 없습니다.');">></span>
        </c:if>
    </div>


    <!-- 글쓰기 버튼 -->
    <div class="text-right">
        <a href="/write"
           class="bg-green-500 hover:bg-green-600 text-white px-5 py-2 rounded shadow-md transition duration-200 ease-in-out">
            ✏️ 글쓰기
        </a>
    </div>

</div>

</body>
</html>
