<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<section>
<a class="button" href="regist.jsp">会員情報登録</a>
<a class="button" href="update.jsp">会員情報更新</a>
<a class="button" href="delete.jsp">会員情報削除</a>
</section>

<style>

.button {
  display: block;
  color: #fff;
  font-size: 16px;
  padding: 1.5rem .5rem;
  background-color: #1755aa;
  text-align: center;
  text-decoration: none;
}
section {
  max-width: 200px;
  margin: 0 auto;
}

</style>

<%@include file="../footer.html" %>