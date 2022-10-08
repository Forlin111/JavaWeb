<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--静态包含公共部分--%>
    <%@include file="/pages/common/head.jsp" %>
    <script>
        //页面加载完成之后
        $(function () {
            $("#sub_btn").click(function () {
                //验证用户名,必须由字母数字下划线组成,长度为5-12;
                //1,获取用户名输入框的内容
                let usernameText = $("#username").val();
                //创建正则表达式对象
                let usernamePatt = /^\w{5,12}$/;
                //使用test()进行验证
                if (!usernamePatt.test(usernameText)) {
                    //提示用户信息 在指定提示错误信息位置
                    $("span.errorMsg").text("用户名不合法!");
                    return false;//组织程序默认行为,比如自动跳转;
                }
                //当用户名合法时讲提示信息取消;
                $("span.errorMsg").text("");

                //验证密码,必须由字母数字下划线组成,长度为5-12;
                //1,获取用户名输入框的内容
                let passwordText = $("#password").val();
                //创建正则表达式对象
                let passwordPatt = /^\w{5,12}$/;
                //使用test()进行验证
                if (!passwordPatt.test(passwordText)) {
                    //提示用户信息 在指定提示错误信息位置
                    $("span.errorMsg").text("密码不合法!");
                    return false;//组织程序默认行为,比如自动跳转;
                }
                //当密码合法时讲提示信息取消;
                $("span.errorMsg").text("");

                //验证确认密码是否和密码一致
                //获取确认密码内容
                let repwdText = $("#repwd").val();
                if (repwdText != passwordText) {
                    $("span.errorMsg").text("确认密码和密码不一致");
                    return false;
                }

                //邮箱验证
                let emailText = $("#email").val();
                let emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("电子邮箱格式不合法");
                    return false;
                }

                //验证码验证
                let codeText = $("#code").val().trim();
                if (codeText == null && codeText == "") {
                    $("span.errorMsg").text("验证码为空");
                    return false;
                }
                return true;
            })
            //给验证码单击事件
            $("#code_img").click(function () {
                //通过赋值的不同来跳过浏览器的缓存
                this.src="${basePath}/KaptchaServlet?d="+new Date();
            })
            $("#username").blur(function () {
                let username = this.value;
                $.getJSON("http://localhost:8088/book/userServlet","action=ajaxExistUsername&username="+username,function (data) {
                        if(data.existUsername){
                            $("span.errorMsg").text("用户名已存在!");
                        }else {
                            $("span.errorMsg").text("用户名可用!");
                        }
                })
            })
        });
    </script>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        <%--<%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text"
                               placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="${requestScope.username}">
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt"
                               type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                               value="${requestScope.email}">
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" id="code"
                               name="code" placeholder="请输入验证码"
                               value=<%=request.getAttribute("code")==null?"":request.getAttribute("code")%>>
                        <img alt="" id="code_img" src="KaptchaServlet" style="float: right; margin-right: 40px;
                        width: 110px;height:40px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>