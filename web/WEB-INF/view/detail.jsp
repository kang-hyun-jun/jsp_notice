<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 상세보기</title>
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

<!-- 컨텐츠 -->
<div class="max-w-4xl mx-auto py-10 px-4">
    <h1 class="text-3xl font-bold mb-6">📖 게시글 상세보기</h1>

    <!-- 게시글 정보 -->
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl font-bold mb-4">${notice.title}</h2>
        <p class="text-gray-600 mb-2"><span class="font-semibold">작성자:</span> ${notice.writer_id}</p>
        <p class="text-gray-600 mb-2"><span class="font-semibold">작성일시:</span> ${notice.regdate}</p>
        <p class="text-gray-600 mb-4"><span class="font-semibold">조회수:</span> ${notice.hit}</p>

        <hr class="my-4">

        <!-- 게시글 내용 -->
        <p class="text-gray-700 leading-relaxed">
            ${notice.content}
        </p>

        <!-- 목록으로 돌아가기 버튼 -->
        <div class="mt-6 text-right">
            <a href="/list"
               class="bg-gray-500 hover:bg-gray-600 text-white px-5 py-2 rounded shadow-md transition duration-200 ease-in-out">
                목록으로 돌아가기
            </a>
        </div>
    </div>

    <!-- 이전 글 / 다음 글 -->
    <div class="mt-8 bg-white p-6 rounded-lg shadow-lg">
        <!-- 이전 글 -->
        <div class="mb-4">
            <p class="text-gray-600 font-semibold mb-2">← 이전 글</p>
            <c:if test="${param.id>1}">
            <a href="/detail?id=${param.id-1}"
               class="text-blue-500 hover:underline text-lg">
                ${prevNotice.title}
            </a>
            </c:if>
            <c:if test="${param.id<=1}">
                <p class="text-gray-600 font-semibold mb-2">이전 글이 없습니다.</p>
            </c:if>

</div>

        <!-- 다음 글 -->
        <div>
            <p class="text-gray-600 font-semibold mb-2">다음 글 →</p>
            <c:if test="${param.id<count}">
                <a href="/detail?id=${param.id+1}"
                   class="text-blue-500 hover:underline text-lg">
                    ${nextNotice.title}
                </a>
            </c:if>
            <c:if test="${param.id>=count}">
                <p class="text-gray-600 font-semibold mb-2">다음 글이 없습니다.</p>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
