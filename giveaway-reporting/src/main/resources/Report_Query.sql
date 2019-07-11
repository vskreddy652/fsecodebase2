SELECT 
dm1.type_code Item_Category,  
inv.item_name,
inv.item_count,
dm2.type_code Item_Status,
inv.item_upload_date,
MONTHNAME(inv.item_upload_date) upload_month,
QUARTER(inv.item_upload_date) upload_quarter,
YEAR(inv.item_upload_date) upload_year,
DAYOFMONTH(inv.item_upload_date) upload_date,
concat(COALESCE(usr.user_first_name, ''), ' ', COALESCE(usr.user_last_name, '')) user_name
FROM 
giveaway.inventory inv,
giveaway.domain dm1,
giveaway.domain dm2,
giveaway.users usr

WHERE inv.item_cat_id = dm1.id
AND dm1.type_name = 'ItemCategory'
AND inv.item_status_id = dm2.id
AND dm2.type_name = 'ItemStatus'
AND inv.user_id = usr.id
AND COALESCE(dm1.type_code, '') = COALESCE(null,COALESCE(dm1.type_code, '')) #Item_Category
AND COALESCE(dm2.type_code, '') = COALESCE(null,COALESCE(dm2.type_code, '')) #Item_Status
AND COALESCE(QUARTER(inv.item_upload_date), 0) = COALESCE(null, COALESCE(QUARTER(inv.item_upload_date), 0))
AND COALESCE(YEAR(inv.item_upload_date),0) = COALESCE(null, COALESCE(YEAR(inv.item_upload_date),0))
AND COALESCE(usr.user_name, '') = COALESCE(null,COALESCE(usr.user_name, '')) #User Name;