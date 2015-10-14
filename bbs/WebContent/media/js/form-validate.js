var FormValidation = function() {

	return {
		// main function to initiate the module
		init : function() {
			$('.user-form')
					.validate(
							{
								errorElement : 'label', // default input error
								// message container
								errorClass : 'help-inline', // default input
								// error message
								// class
								focusInvalid : false, // do not focus the last
								// invalid input
								rules : {
									username : {
										required : true
									},
									password : {
										required : true

									},
									rpassword : {
										equalTo : "#password"
									},
									jcaptchaCode : {
										required : true,
										remote : {
											url : "validate",
											type : "get",
											cache : false,
											dataType : "json",
											data : {
												fieldId : "jcaptchaCode",
												fieldValue : function() {
													return $("#jcaptchaCode")
															.val();
												}
											}
										}
									}
								},

								messages : {
									username : {
										required : "用户名不能为空"
									},
									password : {
										required : "密码不能为空"
									},
									rpassword : {
										equalTo : "两次密码输入不一致"
									},
									jcaptchaCode : {
										required : "验证码不能为空",
										remote : "验证码错误"
									}
								},

								invalidHandler : function(event, validator) { // display
									// error
									// alert
									// on
									// form
									// submit
									$('.alert-error', $('.user-form')).show();
								},

								highlight : function(element) { // hightlight
									// error inputs
									$(element).closest('.control-group')
											.addClass('error'); // set error
									// class to the
									// control group
								},

								success : function(label) {
									label.closest('.control-group')
											.removeClass('error');
									label.remove();
								},

								errorPlacement : function(error, element) {
									error
											.addClass(
													'help-small no-left-padding')
											.insertAfter(
													element
															.closest('.input-icon'));
								}

							});

			$('.signup-form')
					.validate(
							{
								errorElement : 'label', // default input error
								// message container
								errorClass : 'help-inline', // default input
								// error message
								// class
								focusInvalid : false, // do not focus the last
								// invalid input
								rules : {
									username : {
										required : true,
										rangelength : [ 4, 20 ],
										remote : {
											url : "validate",
											type : "get",
											cache : false,
											dataType : "json",
											data : {
												fieldId : "username",
												fieldValue : function() {
													return $("#username").val();
												}
											}
										}
									},
									password : {
										required : true,
										rangelength : [ 4, 20 ]
									},
									rpassword : {
										equalTo : "#password"
									},
									jcaptchaCode : {
										required : true
									},
									email : {
										required : true,
										email : true,
										remote : {
											url : "validate",
											type : "get",
											cache : false,
											dataType : "json",
											data : {
												fieldId : "email",
												fieldValue : function() {
													return $("#email").val();
												}
											}
										}
									}
								},

								messages : {
									username : {
										required : "用户名不能为空",
										remote : "用户名已被使用",
										rangelength : "用户名最少4个字符，最多20个字符！"
									},
									password : {
										required : "密码不能为空",
										rangelength : "密码最少4个字符，最多20个字符！"
									},
									rpassword : {
										equalTo : "两次密码输入不一致"
									},
									jcaptchaCode : {
										required : "验证码不能为空"
									},
									email : {
										required : "邮箱不能为空",
										email : "请输入正确格式的邮箱",
										remote : "邮箱已被注册"
									}
								},

								invalidHandler : function(event, validator) { // display
									// error
									// alert
									// on
									// form
									// submit
									$('.alert-error', $('.user-form')).show();
								},

								highlight : function(element) { // hightlight
									// error inputs
									$(element).closest('.control-group')
											.addClass('error'); // set error
									// class to the
									// control group
								},

								success : function(label) {
									label.closest('.control-group')
											.removeClass('error');
									label.remove();
								},

								errorPlacement : function(error, element) {
									error
											.addClass(
													'help-small no-left-padding')
											.insertAfter(
													element
															.closest('.input-icon'));
								}

							})

		}

	};

}();