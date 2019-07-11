insert into domain values (101,"Book","ItemCategory_Book",1001,"ItemCategory");
insert into domain values (102,"SchoolKit","ItemCategory_SchoolKit",1002,"ItemCategory");
insert into domain values (103,"Dress","ItemCategory_Dress",1003,"ItemCategory");
insert into domain values (104,"Gadgets","ItemCategory_Gadgets",1004,"ItemCategory");
insert into domain values (105,"Toys","ItemCategory_Toys",1005,"ItemCategory");
insert into domain values (106,"Blanket","ItemCategory_Blanket",1006,"ItemCategory");
insert into domain values (107,"SoftCopyStudyMaterial","ItemCategory_SoftCopyStudyMaterial",1007,"ItemCategory");
insert into domain values (108,"WaitingForAdminApproval","ItemStatus_WaitingForAdminApproval",1008,"ItemStatus");
insert into domain values (109,"ItemCollected","ItemStatus_ItemCollected",1009,"ItemStatus");
insert into domain values (110,"ItemDonatedToNeedy","ItemStatus_ItemDonatedToNeedy",1010,"ItemStatus");
insert into domain values (111,"gwUser","UserRole_GiveAwayUser",1011,"UserRole");
insert into domain values (112,"outVolUser","UserRole_OutreachVolunteer",1011,"UserRole");
insert into domain values (113,"appAdmin","UserRole_ApplicationAdministrator",1013,"UserRole");
insert into domain values (114,"WaitingForCollection","ItemStatus_WaitingForCollection",1014,"ItemStatus");
insert into domain values (115,"Rejected","ItemStatus_Rejected",1015,"ItemStatus");
insert into domain values (116,"ItemRequestedByVolunteer","ItemStatus_ItemRequestedByVolunteer",1016,"ItemStatus");
insert into domain values (117,"ItemAcquiredByVolunteer","ItemStatus_ItemAcquiredByVolunteer",1017,"ItemStatus");

ItemRequestedByVolunteer


CREATE TABLE INVENTORY_SEQUENCE (id INT NOT NULL);
INSERT INTO INVENTORY_SEQUENCE VALUES(1);
UPDATE INVENTORY_SEQUENCE SET id=LAST_INSERT_ID(id+1);