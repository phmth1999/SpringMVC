	const firstPath = location.pathname.split('/')[1];
	function addCart(id){	
		let quanty = document.getElementById("quanty");
		let numQuanty = parseInt(quanty.value);
		let nf = Intl.NumberFormat();	
		$.ajax({
			url: '/'+firstPath+'/'+"api/addcart/"+id+"?quanty="+numQuanty,
			async: false,  
			type: "post",
			data: $(this).serialize(),
			success:function(res){		
				let tableTbodyIconCart = "";
				let TotalQuantyCart = 0;
				let TotalPriceCart = 0;
				$.each(res, function(i, item){
					tableTbodyIconCart +=	'<tr>';
					tableTbodyIconCart +=		'<td class="si-pic">';
					tableTbodyIconCart += 		'<img src="'+'/'+firstPath+'/'+'template/web/img/products/'+item.product.img +'" alt="">';
					tableTbodyIconCart += 	'</td>';						
					tableTbodyIconCart += 	'<td class="si-text">'
					tableTbodyIconCart += 		'<div class="product-selected">';
					tableTbodyIconCart += 			'<div>'+item.product.name+' </div>';
					tableTbodyIconCart += 			'<div>x'+item.quanty +'</div>';
					tableTbodyIconCart += 			'<div>'+nf.format(item.totalPrice)+' vnđ </div>';
					tableTbodyIconCart += 		'</div>';
					tableTbodyIconCart += 	'</td>';						
					tableTbodyIconCart += 	'<td class="si-close"><a onclick="deleteCart('+i+')"><i class="ti-close"></i></a></td>';
					tableTbodyIconCart += '</tr>';
					
					TotalQuantyCart += item.quanty;
					TotalPriceCart += item.totalPrice;		
				});
				
				$('#tableTbodyIconCart').empty();
				$('#tableTbodyIconCart').append(tableTbodyIconCart);
				
				$('.iconTotalQuantyCart').empty();
				$('.iconTotalQuantyCart').append(TotalQuantyCart);
				
				$('.totalPriceIconCart').empty();
				$('.totalPriceIconCart').append(nf.format(TotalPriceCart)+" vnđ");
				
				$('.cart-price').empty();
				$('.cart-price').append(nf.format(TotalPriceCart)+" vnđ");
				
				alert("success");			
			}
		});
	}

	function deleteCart(id){	
		let nf = Intl.NumberFormat();		
		$.ajax({
			url: '/'+firstPath+'/'+"api/deletecart/"+id,
			async: false,  
			type: "post",
			data: $(this).serialize(),
			success:function(res){		
				let tableTbodyIconCart = "";
				let tableTbodyListCart = "";
				let TotalQuantyCart = 0;
				let TotalPriceCart = 0;
				$.each(res, function(i, item){
					tableTbodyIconCart +=	'<tr>';
					tableTbodyIconCart +=		'<td class="si-pic">';
					tableTbodyIconCart += 		'<img src="'+'/'+firstPath+'/'+'template/web/img/products/'+item.product.img +'" alt="">';
					tableTbodyIconCart += 	'</td>';						
					tableTbodyIconCart += 	'<td class="si-text">'
					tableTbodyIconCart += 		'<div class="product-selected">';
					tableTbodyIconCart += 			'<div>'+item.product.name+' </div>';
					tableTbodyIconCart += 			'<div>x'+item.quanty +'</div>';
					tableTbodyIconCart += 			'<div>'+nf.format(item.totalPrice)+' vnđ </div>';
					tableTbodyIconCart += 		'</div>';
					tableTbodyIconCart += 	'</td>';						
					tableTbodyIconCart += 	'<td class="si-close"><a onclick="deleteCartIcon('+i+')"><i class="ti-close"></i></a></td>';
					tableTbodyIconCart += '</tr>';
					
					TotalQuantyCart += item.quanty;
					TotalPriceCart += item.totalPrice;
					
					tableTbodyListCart +='<tr>';
					tableTbodyListCart +=	'<td class="cart-pic first-row"><img src="'+'/'+firstPath+'/'+'template/web/img/products/'+item.product.img+'" alt=""></td>';
					tableTbodyListCart +=	'<td class="cart-title first-row"><h5>'+item.product.name +'</h5></td>';
					tableTbodyListCart +=	'<td class="p-price first-row">'+nf.format(item.product.price)+' vnđ </td>';
					tableTbodyListCart +=	'<td class="qua-col first-row">';
					tableTbodyListCart +=		'<div class="quantity">';
					tableTbodyListCart +=			'<div class="pro-qty">';
					tableTbodyListCart +=				'<span onclick="editCart('+i+','+item.quanty+','+0+')" data-id="'+i +'" class="dec qtybtn">-</span>';
					tableTbodyListCart +=				'<input type="text" value="'+item.quanty +'">';
					tableTbodyListCart +=				'<span onclick="editCart('+i+','+item.quanty+','+1+')" data-id="'+i +'" class="inc qtybtn">+</span>';
					tableTbodyListCart +=			'</div>';
					tableTbodyListCart +=		'</div>';
					tableTbodyListCart +=	'</td>';
					tableTbodyListCart +=	'<td class="total-price first-row">'+nf.format(item.totalPrice)+' vnđ </td>';
					tableTbodyListCart +=	'<td class="close-td first-row"><a onclick="deleteCart('+i+')"><i class="ti-close"></i></a></td>';
					tableTbodyListCart +='</tr>';
				});
				$('#tableTbodyListCart').empty();
				$('#tableTbodyListCart').append(tableTbodyListCart);
				
				$('#tableTbodyIconCart').empty();
				$('#tableTbodyIconCart').append(tableTbodyIconCart);
				
				$('.iconTotalQuantyCart').empty();
				$('.iconTotalQuantyCart').append(TotalQuantyCart);
				
				$('.totalPriceIconCart').empty();
				$('.totalPriceIconCart').append(nf.format(TotalPriceCart)+" vnđ");
				
				$('.cart-total>span').empty();
				$('.cart-total>span').append(nf.format(TotalPriceCart)+" vnđ");
				
				$('.cart-price').empty();
				$('.cart-price').append(nf.format(TotalPriceCart)+" vnđ");
						
			}
		});
	}
	
	function editCart(id, quanty, num) {
		console.log(id)
		console.log(quanty)
		console.log(num)
		let newVal = 0;
		if(num===0){
			newVal = quanty -1;
			if(newVal < 1){
				newVal = 1;
			}
		}
		if(num===1){
			newVal = quanty +1;
		}
		if(id != null){
			/*window.location = "editcart/" + id + "/" + newVal;*/
			$.ajax({
				url: '/'+firstPath+'/'+"api/editcart/"+id+"/"+newVal,
				async: false,  
				type: "post",
				data: $(this).serialize(),
				success:function(res){
					let nf = Intl.NumberFormat();		
					let tableTbodyIconCart = "";
					let tableTbodyListCart = "";
					let TotalPriceCart = 0;
					let TotalQuantyCart = 0;

					$.each(res, function(i, item){
						tableTbodyListCart +='<tr>';
						tableTbodyListCart +=	'<td class="cart-pic first-row"><img src="'+'/'+firstPath+'/'+'template/web/img/products/'+item.product.img+'" alt=""></td>';
						tableTbodyListCart +=	'<td class="cart-title first-row"><h5>'+item.product.name +'</h5></td>';
						tableTbodyListCart +=	'<td class="p-price first-row">'+nf.format(item.product.price)+' vnđ </td>';
						tableTbodyListCart +=	'<td class="qua-col first-row">';
						tableTbodyListCart +=		'<div class="quantity">';
						tableTbodyListCart +=			'<div class="pro-qty">';
						tableTbodyListCart +=				'<span onclick="editCart('+i+','+item.quanty+','+0+')" data-id="'+i +'" class="dec qtybtn">-</span>';
						tableTbodyListCart +=				'<input type="text" value="'+item.quanty +'">';
						tableTbodyListCart +=				'<span onclick="editCart('+i+','+item.quanty+','+1+')" data-id="'+i +'" class="inc qtybtn">+</span>';
						tableTbodyListCart +=			'</div>';
						tableTbodyListCart +=		'</div>';
						tableTbodyListCart +=	'</td>';
						tableTbodyListCart +=	'<td class="total-price first-row">'+nf.format(item.totalPrice)+' vnđ </td>';
						tableTbodyListCart +=	'<td class="close-td first-row"><a onclick="deleteCart('+i+')"><i class="ti-close"></i></a></td>';
						tableTbodyListCart +='</tr>';
						
						tableTbodyIconCart +='<tr>';
						tableTbodyIconCart +=	'<td class="si-pic"><img src="'+'/'+firstPath+'/'+'template/web/img/products/'+item.product.img +'" alt=""></td>';						
						tableTbodyIconCart += 	'<td class="si-text">'
						tableTbodyIconCart += 		'<div class="product-selected">';
						tableTbodyIconCart += 			'<div>'+item.product.name+' </div>';
						tableTbodyIconCart += 			'<div>x'+item.quanty +'</div>';
						tableTbodyIconCart += 			'<div>'+nf.format(item.totalPrice)+' vnđ </div>';
						tableTbodyIconCart += 		'</div>';
						tableTbodyIconCart += 	'</td>';						
						tableTbodyIconCart += 	'<td class="si-close"><a onclick="deleteCartIcon('+i+')"><i class="ti-close"></i></a></td>';
						tableTbodyIconCart +='</tr>';
						
						TotalQuantyCart += item.quanty;
						TotalPriceCart += item.totalPrice;	
					});
					
					$('#tableTbodyListCart').empty();
					$('#tableTbodyListCart').append(tableTbodyListCart);					
					
					$('#tableTbodyIconCart').empty();
					$('#tableTbodyIconCart').append(tableTbodyIconCart);
				
					$('.iconTotalQuantyCart').empty();
					$('.iconTotalQuantyCart').append(TotalQuantyCart);
				
					$('.totalPriceIconCart').empty();
					$('.totalPriceIconCart').append(nf.format(TotalPriceCart)+" vnđ");
				
					$('.cart-total>span').empty();
					$('.cart-total>span').append(nf.format(TotalPriceCart)+" vnđ");
				
					$('.cart-price').empty();
					$('.cart-price').append(nf.format(TotalPriceCart)+" vnđ");
				}	
			});			
		}	
	}
	function tru(){
		let quanty = document.getElementById("quanty");
		let numQuanty = parseInt(quanty.value);
		numQuanty--;
		if(numQuanty < 1){
			numQuanty = 1;
		}
		document.getElementById("quanty").value = numQuanty;
	}
	
	function cong(){
		let quanty = document.getElementById("quanty");
		let numQuanty = parseInt(quanty.value);
		numQuanty++;
		document.getElementById("quanty").value = numQuanty;
	}