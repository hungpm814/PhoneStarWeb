USE [master]
GO
alter database [PhoneDB] set single_user with rollback immediate

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'PhoneDB')
	DROP DATABASE PhoneDB
GO

CREATE DATABASE PhoneDB
GO

use PhoneDB
GO

create table Brand(
	BrandID int Identity(1,1) primary key,
	BrandName varchar(255),
	Detail nvarchar(2000)
)

select * from Version

create table Version(
	PhoneName varchar(255) primary key,
	OS varchar(255),
	RAM int,
	Detail nvarchar(2000),
	Camera int,
	Year int,
	Chip varchar(255),
	Screen varchar(255),
	BrandID int,
	foreign key (BrandID) references Brand(BrandID) on delete cascade,
)

create table Phone(
	Series varchar(255) PRIMARY KEY,
	PhoneName varchar(255),
	Color nvarchar(255),
	ROM varchar(255),
	Price int,
	Quantity int,
	Date date,
	[Image] varchar(255),
	foreign key (PhoneName) references Version(PhoneName) on delete cascade,
)

create table Users(
	UserName varchar(255) primary key,
	Password varchar(255),
	Role int,
	Name nvarchar(255),
	PhoneNumber varchar(255),
	Email varchar(255),
	Address nvarchar(255),
)

create table Bill(
	BillID int primary key,
	UserName varchar(255),
	Date date,
	Total int,
	foreign key (UserName) references Users(UserName) on delete no action,
)

create table Orders(
	BillID int,
	Series varchar(255),
	Quantity int,
	Price int,
	primary key (BillID,Series),
	foreign key (Series) references Phone(Series) on delete cascade,
	foreign key (BillID) references Bill(BillID) on delete cascade,
)

----------Insert----------

--Brand
insert into Brand(BrandName,Detail)
values 
 ('Apple',N'Apple là một tập đoàn công nghệ lớn của Mỹ được thành lập ngày 1 tháng 4 năm 1976. Apple sản xuất nhiều sản phẩm công nghệ cao cấp như iPhone, iPad, MacBook, iMac, Mac mini, AirPods, AirTag, HomePod, Apple TV và một số sản phẩm khác.'),
 ('Samsung',N'Samsung là một thương hiệu sản xuất đồ điện tử có tiếng trên thị trường, trong đó thương hiệu điện thoại Samsung là một thương hiệu nằm trong Công ty Samsung Electronics. Đây là một công ty có trụ sở chính đặt tại Seoul, Hàn Quốc được thành lập năm 1938.'),
 ('Xiaomi',N'Xiaomi là tập đoàn công nghệ nổi tiếng của Trung Quốc, có trụ sở tại Bắc Kinh. Chỉ sau 5 năm thành lập và phát triển, thương hiệu đã trở thành nhà sản xuất smartphone có thị phần đứng thứ 5 thế giới và đứng thứ 1 tại thị trường quê nhà (tính đến năm 2015).'),
 ('Oppo',N'OPPO là một thương hiệu điện thoại nổi tiếng của công ty OPPO Electronics, có trụ sở tại Quảng Đông, Trung Quốc. Công ty được thành lập vào năm 2004 và đã phát triển thành một trong những nhà sản xuất thiết bị thông minh hàng đầu thế giới, với hoạt động kinh doanh mở rộng đến hơn 60 quốc gia và khu vực.'),
 ('Realme',N'realme được thành lập bởi Li Bingzhong (còn được biết đến với tên Sky Li) vào ngày 4 tháng 5 năm 2018. Ban đầu, realme chỉ là một thương hiệu con của OPPO, nhưng sau đó đã trở thành một thương hiệu độc lập.'),
 ('Nokia',N'Một hãng điện thoại có lịch sử lâu đời với những sản phẩm chất lượng cao với tính bền bỉ và thiết kế đẹp mắt')

--Version
insert into Version values ('iPhone 15 Pro Max','IOS 17',8,N'iPhone 15 Pro Max là một chiếc điện thoại thông minh cao cấp với nhiều ưu điểm nổi bật, bao gồm thiết kế đẹp mắt, hiệu năng mạnh mẽ, camera tuyệt vời và mức giá hợp lý.',60,2023,'Apple A17','OLED, 6.7"',1)
insert into Version values ('iPhone 15 Pro','IOS 17',8,N'iPhone 15 Pro là một chiếc điện thoại thông minh cao cấp với nhiều ưu điểm nổi bật, bao gồm thiết kế đẹp mắt, hiệu năng mạnh mẽ, camera tuyệt vời và mức giá hợp lý.',60,2023,'Apple A17','OLED, 6.1"',1)
insert into Version values ('iPhone 15','IOS 17',6,N'iPhone 15 là một chiếc điện thoại thông minh cao cấp với nhiều ưu điểm nổi bật, bao gồm thiết kế đẹp mắt, hiệu năng mạnh mẽ, camera tuyệt vời và mức giá hợp lý.',60,2023,'Apple A16','OLED, 6.1"',1)
insert into Version values ('iPhone 15 Plus','IOS 17',6,N'iPhone 15 Plus là một chiếc điện thoại thông minh cao cấp với nhiều ưu điểm nổi bật, bao gồm thiết kế đẹp mắt, hiệu năng mạnh mẽ, camera tuyệt vời và mức giá hợp lý.',60,2023,'Apple A16','OLED, 6.7"',1)
insert into Version values ('iPhone 14 Pro Max','IOS 16',6,N'iPhone 14 Pro Max là một chiếc điện thoại thông minh cao cấp với nhiều ưu điểm nổi bật, bao gồm thiết kế đẹp mắt, hiệu năng mạnh mẽ, camera tuyệt vời và mức giá hợp lý.',48,2022,'Apple A16','OLED, 6.7"',1)
insert into Version values ('iPhone 14','IOS 16',6,N'iPhone 14 là một chiếc điện thoại thông minh cao cấp với nhiều ưu điểm nổi bật, bao gồm thiết kế đẹp mắt, hiệu năng mạnh mẽ, camera tuyệt vời và mức giá hợp lý.',24,2022,'Apple A15','OLED, 6.1"',1)
insert into Version values ('iPhone 13','IOS 15',4,N'Hãng điện thoại Apple đã mang đến cho người dùng một siêu phẩm mới iPhone 13 với nhiều cải tiến thú vị sẽ mang lại những trải nghiệm hấp dẫn nhất cho người dùng.',24,2021,'Apple A15','OLED, 6.1"',1)

insert into Version values ('Samsung Galaxy S24 5G','Android 14',8,N'Trong sự kiện Unpacked 2024 diễn ra vào ngày 18/01, Samsung đã chính thức ra mắt chiếc điện thoại Samsung Galaxy S24. Sản phẩm này mang đến nhiều cải tiến độc đáo, bao gồm việc sử dụng chip mới của Samsung, tích hợp nhiều tính năng thông minh sử dụng trí tuệ nhân tạo và cải thiện đáng kể hiệu suất chụp ảnh từ hệ thống camera.',82,2024,'Exynos 2400','Dynamic AMOLED 2X, 6.2"',2)
insert into Version values ('Samsung Galaxy S24 Ultra 5G','Android 14',12,N'Samsung Galaxy S24 Ultra mẫu điện thoại cao cấp được ra mắt vào đầu năm 2024, sản phẩm tiếp tục kế thừa và cải tiến từ thế hệ trước. Điểm đặc biệt là sử dụng chip Snapdragon 8 Gen 3 for Galaxy, camera 200 MP và tích hợp nhiều tính năng AI.',200,2024,'Snapdragon 8 Gen 3 for Galaxy','Dynamic AMOLED 2X, 6.8", Quad HD+',2)
insert into Version values ('Samsung Galaxy S23 FE 5G','Android 13',8,N'Samsung tiếp tục chiếm lĩnh thị trường điện thoại thông minh với sự xuất hiện của Samsung Galaxy S23 FE 5G. Điện thoại này được trang bị camera 50 MP có khả năng quay video 8K, màn hình 120 Hz. Với những tính năng này, hứa hẹn sẽ mang đến trải nghiệm tuyệt vời, đáp ứng mọi nhu cầu của người dùng.',70,2023,'Exynos 2200','Dynamic AMOLED 2X, 6.4", Full HD+',2)
insert into Version values ('Samsung Galaxy A25 5G','Android 14',8,N'Samsung Galaxy A25 5G mẫu điện thoại thuộc dòng Galaxy A được Samsung tung ra thị trường Việt Nam vào những dịp cuối năm 2023. Lần ra mắt này máy sở hữu màn hình Super AMOLED hiển thị rõ nét, hiệu năng ổn định đi cùng với đó là một thiết kế trẻ trung.',60,2023,'Exynos 1280','Super AMOLED, 6.5", Full HD+',2)

insert into Version values ('OPPO Reno11 Pro 5G','Android 14',12,N'OPPO Reno11 Pro 5G sự tiếp nối của thành công từ thế hệ trước, với thiết kế lôi cuốn, cấu hình mạnh mẽ và khả năng chụp ảnh vượt trội. Được tạo ra để đáp ứng nhu cầu đa dạng của người dùng, điện thoại là sự lựa chọn tuyệt vời cho những người đang tìm kiếm một thiết bị đa năng và hiện đại.',90,2023,'MediaTek Dimensity 8200 5G','AMOLED, 6.7", Full HD+',4)
insert into Version values ('OPPO OPPO A98 5G','Android 13',8,N'Những mẫu điện thoại OPPO cho ra mắt thời gian gần đây (2023) có vẻ ngoài đẹp mắt phù hợp với thị hiếu người tiêu dùng hiện nay. Trong đó OPPO A98 5G mẫu điện thoại mới của điện thoại OPPO A, với lối thiết kế hiện đại, màn hình hiển thị chi tiết thông tin cũng như một hiệu năng ổn định.',68,2022,'Snapdragon 695','LTPS LCD, 6.72", Full HD+',4)

--Phone
insert into Phone(Series,PhoneName,Color,ROM,Price,Quantity,Date,Image)
values 
	('ss1','Samsung Galaxy S24 Ultra 5G',N'Xám','256GB',33990000,10,'2024-02-20','images/samsung-galaxys24ultra-xam.jpg'),
	('ss2','Samsung Galaxy S24 Ultra 5G',N'Tím','256GB',33890000,10,'2023-02-20','images/samsung-galaxys24ultra-tim.jpg'),
	('ss3','Samsung Galaxy S24 Ultra 5G',N'Xám','512GB',37490000,10,'2023-02-20','images/samsung-galaxys24ultra-xam.jpg'),
	('ss4','Samsung Galaxy S24 Ultra 5G',N'Tím','512GB',37290000,10,'2023-02-20','images/samsung-galaxys24ultra-tim.jpg'),
	('ss5','Samsung Galaxy S24 Ultra 5G',N'Xám','1TB',42490000,10,'2023-02-21','images/samsung-galaxys24ultra-xam.jpg'),

	('ss6','Samsung Galaxy S24 5G',N'Xám','128GB',22990000,10,'2024-02-21','images/samsung-galaxys24-xam.jpg'),
	('ss7','Samsung Galaxy S24 5G',N'Xám','256GB',26990000,10,'2023-02-21','images/samsung-galaxys24-xam.jpg'),

	('ip1','iPhone 15 Pro Max',N'Titan xanh','256GB',30990000,10,'2024-02-25','images/iphone-15promax-xanh.jpg'),
	('ip2','iPhone 15 Pro Max',N'Titan xanh','512GB',37990000,10,'2023-02-25','images/iphone-15promax-xanh.jpg'),
	('ip3','iPhone 15 Pro Max',N'Titan tự nhiên','256GB',31990000,10,'2023-02-25','images/iphone-15promax-tunhien.jpg'),

	('ip4','iPhone 15 Pro',N'Titan đen','128GB',27490000,10,'2024-02-25','images/iphone-15pro-den.jpg'),
	('ip5','iPhone 15 Pro',N'Titan đen','256GB',29490000,10,'2023-02-25','images/iphone-15pro-den.jpg'),
	('ip6','iPhone 15 Pro',N'Titan đen','512GB',35490000,10,'2023-02-25','images/iphone-15pro-den.jpg'),

	('ip7','iPhone 15 Plus',N'Hồng nhạt','128GB',23490000,10,'2024-02-25','images/iphone-15plus-hong.jpg'),
	('ip8','iPhone 15 Plus',N'Hồng nhạt','256GB',25990000,10,'2023-02-25','images/iphone-15plus-hong.jpg'),

	('ip9','iPhone 15',N'Vàng nhạt','128GB',20990000,10,'2023-02-25','images/iphone-15-vang.jpg'),
	('ip10','iPhone 15',N'Vàng nhạt','256GB',23990000,10,'2023-02-25','images/iphone-15-vang.jpg')

--Users
insert into Users (UserName, Password, Role, Name, PhoneNumber, Email, Address) 
values
('admin', '12345', 1, N'Admin', '0123456789', 'admin@gmail.com', N'Hoa Lac'),
('user1', 'password1', 1, N'Người dùng 1', '1234567890', 'user1@example.com', N'Địa chỉ 1'),
('user2', 'password2', 0, N'Người dùng 2', '1234567891', 'user2@example.com', N'Địa chỉ 2'),
('user3', 'password3', 0, N'Người dùng 3', '1234567892', 'user3@example.com', N'Địa chỉ 3'),
('user4', 'password4', 0, N'Người dùng 4', '1234567893', 'user4@example.com', N'Địa chỉ 4'),
('user5', 'password5', 0, N'Người dùng 5', '1234567894', 'user5@example.com', N'Địa chỉ 5'),
('user6', 'password6', 0, N'Người dùng 6', '1234567895', 'user6@example.com', N'Địa chỉ 6'),
('user7', 'password7', 0, N'Người dùng 7', '1234567896', 'user7@example.com', N'Địa chỉ 7'),
('user8', 'password8', 0, N'Người dùng 8', '1234567897', 'user8@example.com', N'Địa chỉ 8'),
('user9', 'password9', 0, N'Người dùng 9', '1234567898', 'user9@example.com', N'Địa chỉ 9'),
('user10', 'password10', 0, N'Người dùng 10', '1234567899', 'user10@example.com', N'Địa chỉ 10');
