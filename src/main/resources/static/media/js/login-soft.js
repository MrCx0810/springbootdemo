var Login = function () {
    
    return {
        //main function to initiate the module
        init: function () {
	        jQuery('#forget-password').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.forget-form').show();
	        });

	        jQuery('#back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.forget-form').hide();
	        });

	        $.backstretch([
                "../static/media/image/bg/6.jpg",
                "../static/media/image/bg/5.jpg",
                "../static/media/image/bg/8.jpg",
                "../static/media/image/bg/7.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		      });
        }

    };

}();