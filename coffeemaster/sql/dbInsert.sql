PRODUCT SCRIPT

INSERT INTO public.product(
	id, productname, productprice)
	VALUES (1, 'Filtre Kahve', '4');
	
	
	INSERT INTO public.product(
	id, productname, productprice)
	VALUES (2, 'Latte', '5');
	
		INSERT INTO public.product(
	id, productname, productprice)
	VALUES (3, 'Mocha', '6');
	
		INSERT INTO public.product(
	id, productname, productprice)
	VALUES (4, 'Cay', '3');
	
		INSERT INTO public.product(
	id, productname, productprice)
	VALUES (5, 'Türk Kahvesi', '5');
	
	-------------------------------------------
	
	ADDITION SCRIPT
	
	INSERT INTO public.addition(
	id, additionname, additionprice)
	VALUES (1, 'Süt', '2');
	
	
	INSERT INTO public.addition(
	id, additionname, additionprice)
	VALUES (2, 'Fındık Surubu', '3');
	
	INSERT INTO public.addition(
	id, additionname, additionprice)
	VALUES (3, 'Cikolata Sosu', '5');
	
	INSERT INTO public.addition(
	id, additionname, additionprice)
	VALUES (4, 'Limon', '2');
	
	-----------------------------------------------------------
	RELATION
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (1, 1, 1);
	
	
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (2, 1, 2);
	
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (3, 1, 3);
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (4, 2, 1);
	
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (5, 2, 3);
	
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (6, 3, 2);
	
	
	INSERT INTO public.relation_model(
	id, addition_id, product_id)
	VALUES (7, 4, 4);