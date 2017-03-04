<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
<!DOCTYPE html>
<html>
   <head>
	   <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="ThemeBucket">
	    <link rel="shortcut icon" href="#" type="image/png">
      <title>SemEval2010</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <!-- 引入 Bootstrap -->
 	  <link href="<c:url value='/styles/bootstrap.min.css'/>" rel="stylesheet">
	  <link href="<c:url value='/styles/bootstrap-theme.min.css'/>" rel="stylesheet">
	  <script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
	  <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	  
	  <link href="<c:url value='/styles/semeval/basic.css'/>" rel="stylesheet">
	  <script src="<c:url value='/js/semeval/dataprocess.js'/>"></script>
	  
      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
   </head>
<body>
	<div id="content">
		<div id="num" class="base"></div>
		<div id="orginsentence" class="base"></div>
		<div id="wordspostag" class="base"></div>
		<div id="classification" class="base"></div>
		<div class="row">
		  <div class="col-md-4" id="patternleft">
		  	
		  </div>
		  <div class="col-md-4" id="patternmiddle">
		  	
		  </div>
		  <div class="col-md-4" id="patternright">
		  	
		  </div>
		</div>
		
	</div>
	<script type="text/javascript">
	
		$(document).ready(function(){ 
			getOneDoc();
		}); 
		
	</script>
</body>
</html>