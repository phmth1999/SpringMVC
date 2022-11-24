	/*Active click category and brand*/
	var path = window.location.href;
	$('.filter-catagories li a').each(function() {
	      if (this.href.split('?')[0] === path.split('?')[0]) {
	         $(this).addClass('active');
	      }
	});
	
	