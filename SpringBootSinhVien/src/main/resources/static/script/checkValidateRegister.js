$(document).ready(function () {
	jQuery.validator.addMethod("account", function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9]*$/i.test(value);
		}, "Vui lòng nhập đúng định dạng tài khoản (ký tự 1 byte) ");
    $( "#formRegister" ).validate({
        rules: {
            user_name: {
                required: true,
                minlength: 6,
                account: true
            },
            password_user: {
                required: true,
                minlength: 6
            },
            password_user_confirm: {
                required: true,
                minlength: 6,
                equalTo: "#password_user"
            },
        },
        messages: {
            user_name: {
                required: "Vui lòng nhập email",
                minlength: "Vui lòng nhập ít nhất 6 kí tự",
            },
            password_user: {
                required: 'Vui lòng nhập mật khẩu',
                minlength: 'Vui lòng nhập ít nhất 6 kí tự'
            },
            password_user_confirm: {
                required: 'Vui lòng nhập mật khẩu',
                minlength: 'Vui lòng nhập ít nhất 6 kí tự',
                equalTo: 'Password chưa giống nhau'
            },
            submitHandler: function(form) {
                form.submit();
            }
        }
    });
})