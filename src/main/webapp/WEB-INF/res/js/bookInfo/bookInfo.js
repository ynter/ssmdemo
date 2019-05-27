function deleteBookInfo(bookInfoId) {
	var form = $("#deleteForm");
	form.find('input')[0].value = bookInfoId;
	form.submit();
}

function modifyFun(id,name,author,isbn,price){
	var form = $("#modifyForm");
	form.find('input')[0].value = name;
	form.find('input')[1].value = author;
	form.find('input')[2].value = isbn;
	form.find('input')[3].value = price;
	form.find('input')[4].value = id;
}