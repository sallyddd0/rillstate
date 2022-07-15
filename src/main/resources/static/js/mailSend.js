/**
 * 
 */
 
$(function(){
	$("#btn-mail").click(function(){
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			beforeSend: function(xhr){xhr.setRequestHeader(header, token);},
			url:"/request-key/mail",
			type: "post",
			data: {email:$("#in-mail").val()},
			success:function(result){
				if(result){
					var ss=/*[[${session.mailKey}]]*/null;
					alert(ss);
				}
			}
		});
	});
});