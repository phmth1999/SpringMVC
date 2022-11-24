
(function ($) {
	/*Search auto*/
	 const firstPath = location.pathname.split('/')[1];
	 $("#inputSearch").autocomplete({
		    source: '/'+firstPath+'/'+'search',
		    create: function() {
		      $(this).data('ui-autocomplete')._renderItem = function(ul, item) {
		    		  return $('<li>')
		    		  .append('<a href="/'+firstPath+'/product/' + item.id + '" style="display:flex;justify-content: left;align-items: center;">'
		        		  +'<div>'
		        		  +'<img style="height: 100px;width: 100px;" class="icon" src="/'+firstPath+'/template/web/img/products/' + item.img + '" />'
		        		  +'</div>'
		        		  +'<div style="margin-left: 20px;font-size: 16px;">'
		        		  + item.name
		        		  +'</div>'
		        		  +'</a>'
		        		  )
		        	  .appendTo(ul);
		      };
		    }
	});
	/* Backtop button event */
	   $('.backtop').click(function(){
	      $('html , body').animate({scrollTop:0},500);
	   });
	   
	   $('.backtop').hide();
	   
	   $(window).scroll(function(){
	     if($(this).scrollTop()){
	        $('.backtop').fadeIn();
	     }else{
	        $('.backtop').fadeOut();
	     }
	   });
    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(100).fadeOut("slow");
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*------------------
        Hero Slider
    --------------------*/
    $(".hero-items").owlCarousel({
        loop: true,
        margin: 0,
        nav: true,
        items: 1,
        dots: false,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
    });

    /*------------------
        Product Slider
    --------------------*/
   $(".product-slider").owlCarousel({
        loop: true,
        margin: 25,
        nav: true,
        items: 4,
        dots: true,
        navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {
            0: {
                items: 1,
            },
            576: {
                items: 2,
            },
            992: {
                items: 2,
            },
            1200: {
                items: 3,
            }
        }
    });


    /*-----------------------
       Product Single Slider
    -------------------------*/
    $(".ps-slider").owlCarousel({
        loop: false,
        margin: 10,
        nav: true,
        items: 3,
        dots: false,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
    });

    /*------------------
		Single Product
	--------------------*/
	$('.product-thumbs-track .pt').on('click', function(){
		$('.product-thumbs-track .pt').removeClass('active');
		$(this).addClass('active');
		var imgurl = $(this).data('imgbigurl');
		var bigImg = $('.product-big-img').attr('src');
		if(imgurl != bigImg) {
			$('.product-big-img').attr({src: imgurl});
			$('.zoomImg').attr({src: imgurl});
		}
	});

    $('.product-pic-zoom').zoom();
    
	
		 
})(jQuery);

