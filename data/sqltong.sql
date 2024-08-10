﻿
CREATE DATABASE QuanLyBanVe
GO
USE QuanLyBanVe
GO

CREATE TABLE LoaiNhanVien
(
	MaLoaiNV varchar(10) not null constraint PK_LNV PRIMARY KEY,
	TenLoaiNV nvarchar(40),
);

CREATE TABLE TaiKhoanNV
(
	MaTaiKhoan varchar(10) not null constraint PK_TaiKhoanNV PRIMARY KEY,
	MatKhau varchar(40),
);

CREATE TABLE KhachHang
(
	MaKH varchar(14) not null constraint PK_KH PRIMARY KEY,
	TenKhachHang nvarchar(50),
	SoDienThoai nvarchar(15),
	DiaChi nvarchar(100),
	NgaySinh date
);

CREATE TABLE Ghe
(
	MaGhe varchar(10) not null constraint PK_GHE primary key,
	TrangThai bit
);

CREATE TABLE DangChieu(
	MaDangChieu varchar(10) not null constraint PK_DangChieu primary key,
	TenDangChieu nvarchar(20) null
);

CREATE TABLE LoaiVe(
	MaLoaiVe varchar(10) not null constraint PK_LoaiVe primary key,
	TenLoaiVe nvarchar(20) null,
	GiaLoaiVe money null
);

CREATE TABLE LoaiPhim(
	MaLoaiPhim varchar(10) not null constraint PK_LoaiPhim primary key,
	TenTheLoai nvarchar(50)	
);

CREATE TABLE PhongChieu(
	MaPhongChieu varchar(10) not null constraint PK_PhongChieu primary key,
	TenPhongChieu nvarchar(50),	
	SoLuongGhe int,
	MoTa nvarchar(100)
);

CREATE TABLE NhanVien(
	MaNV varchar(10) not null constraint PK_NhanVien primary key, constraint FK_MaNV_NhanVien_TaiKhoanNV FOREIGN KEY (MaNV) REFERENCES TaiKhoanNV(MaTaiKhoan),
	TenNV nvarchar(50), 
	SDT varchar(20),
	CMD varchar(20), 
	MaLoaiNV varchar(10), Constraint FK_NhanVien_LoaiNhanVen Foreign key(MaLoaiNV) references LoaiNhanVien(MaLoaiNV)
); 

ALTER TABLE  NhanVien DROP Constraint FK_MaNV_NhanVien_TaiKhoanNV
ALTER TABLE  NhanVien ADD Constraint FK_MaNV_NhanVien_TaiKhoanNV FOREIGN KEY (MaNV) REFERENCES TaiKhoanNV(MaTaiKhoan) ON UPDATE CASCADE ON DELETE CASCADE


CREATE TABLE HoaDon(
	MaHoaDon varchar(10) not null Constraint PK_HoaDon primary key,
	MaKH varchar(14) Constraint FK_MaKH_HoaDon_KhachHang FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),	
	NgayLapHD date,
	MaNhanVien varchar(10) Constraint FK_MaNhanVien_HoaDon_NhanVien FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNV)
);

CREATE TABLE Phim(
	MaPhim varchar(10) primary key not null,
	TenPhim nvarchar(30) null,
	GiaPhim money null, 
	MaLoaiPhim varchar(10) not null Constraint FK_MaLoaiPhim_Phim FOREIGN KEY (MaLoaiPhim) REFERENCES LoaiPhim(MaLoaiPhim),
	MaDangChieu varchar(10) not null Constraint FK_MaDangChieu_Phim FOREIGN KEY (MaDangChieu) REFERENCES DangChieu(MaDangChieu) 
); 

ALTER TABLE Phim
ALTER COLUMN TenPhim nvarchar(50);

CREATE TABLE LichChieu(
	MaLichChieu varchar(10) primary key not null,
	ThoiGianChieu datetime,
	ThoiGianKetThuc datetime,
	NgayChieu date,
	MaPhongChieu varchar(10) not null Constraint FK_MaPhongChieu_LichChieu FOREIGN KEY (MaPhongChieu) REFERENCES PhongChieu(MaPhongChieu),
	MaPhim varchar(10) not null Constraint FK_MaPhim_LichChieu FOREIGN KEY (MaPhim) REFERENCES Phim(MaPhim)
); 

CREATE TABLE VePhim
(
	MaVe varchar(15) primary key not null,
	MaLoaiVe varchar(10) not null constraint FK_VePhim_LoaiVe foreign key (MaLoaiVe) REFERENCES LoaiVe(MaLoaiVe),
	MaPhim varchar(10) not null constraint FK_VePhim_Phim foreign key (MaPhim) REFERENCES Phim(MaPhim),
	MaLichChieu varchar(10) not null constraint FK_VePhim_LichChieu foreign key (MaLichChieu) references LichChieu(MaLichChieu),
	MaGhe varchar(10) not null constraint FK_VePhim_Ghe foreign key (MaGhe) references Ghe(MaGhe),
	Gia money,
	Mota nvarchar(100)
); 

CREATE TABLE ChiTietHoaDon(
	MaVe varchar(15) not null Constraint FK_MaVe_ChiTietHoaDon Foreign key (MaVe) references VePhim(MaVe),
	MaHoaDon varchar(10) not null Constraint FK_MaHoaDon_ChiTietHoaDon Foreign key(MaHoaDon) references HoaDon(MaHoaDon),
	SoLuong int,
	NgayLapHoaDon datetime
); 

-- Insert 

-- LoaiNhanVien
INSERT INTO LoaiNhanVien VALUES('LNV001',N'Nhân Viên Bán Vé')
INSERT INTO LoaiNhanVien VALUES('LNV002',N'Quản Lý')

-- TaiKhoanNV
INSERT INTO TaiKhoanNV VALUES('NV001', 'Quanlybanve01')
INSERT INTO TaiKhoanNV VALUES('NV002', 'Quanlybanve02')
INSERT INTO TaiKhoanNV VALUES('NV003', 'Quanlybanve03')
INSERT INTO TaiKhoanNV VALUES('NV004', 'Quanlybanve04')
INSERT INTO TaiKhoanNV VALUES('NV005', 'Quanlybanve05')
INSERT INTO TaiKhoanNV VALUES('NV006', 'Quanlybanve06')
INSERT INTO TaiKhoanNV VALUES('NV007', 'Quanlybanve07')
INSERT INTO TaiKhoanNV VALUES('NV008', 'Quanlybanve08')

-- KhachHang
INSERT INTO KhachHang VALUES('KH0001',N'Nguyễn Thu Hương','0123456789',N'244 Đinh Tiên Hoàng, Hoa Lư, Ninh Bình','2010-01-20')
INSERT INTO KhachHang VALUES('KH0002',N'Đặng Trần Tấn Phát','0123456788',N'301 Đinh Tiên Hoàng, Hoa Lư, Ninh Bình','2004-02-20')
INSERT INTO KhachHang VALUES('KH0003',N'Trần Nguyễn Quốc Thắng','0123456781',N'Cần Giuộc,Long An','2011-05-01')
INSERT INTO KhachHang VALUES('KH0004',N'Đặng Văn Toàn','0123456782',N'Ninh Bình','2001-01-02')
INSERT INTO KhachHang VALUES('KH0005',N'Nguyễn Quang Huy','0123456777',N'41,Lý Thường Kiệt,Quận 10,TPHCM','2010-01-20')
INSERT INTO KhachHang VALUES('KH0006',N'Hà Văn Quát','0125456711',N'10,Lý Thái Tổ,Quận 10,TPHCM','2008-01-20')
INSERT INTO KhachHang VALUES('KH0007',N'Cao Trọng Tấn','0123456123',N'233,Hoàng Kiếm,Hà Nội','2011-03-22')
INSERT INTO KhachHang VALUES('KH0008',N'Lương Tấn Phong','0123456721',N'34,Nguyễn Oanh,Gò Vấp,TPHCM','2011-03-20')
INSERT INTO KhachHang VALUES('KH0009',N'Hà Thị Thu Trang','0123456281',N'111,Lạc Long Quân,Quận 11,TPHCM','2011-01-09')
INSERT INTO KhachHang VALUES('KH0010',N'Linh Hà Tĩnh','0123123123',N'313,Nguyễn Thái Sơn,Gò Vấp,TPHCM','2002-02-20')
INSERT INTO KhachHang VALUES('KH0011',N'Nguyễn Thu Hường','0912367891',N'Hà Tĩnh','2001-10-09')
INSERT INTO KhachHang VALUES('KH0012',N'Nguyễn Giang','0891278913',N'Nguyễn Kiệm,TPHCM','1999-07-01')
INSERT INTO KhachHang VALUES('KH0013',N'Đào Thị Minh Giang','0123456119',N'142 Lý Thái Tổ, Quận Đống Đa, Hà Nội','2020-04-20')
INSERT INTO KhachHang VALUES('KH0014',N'Nguyễn Thị Minh An','0123456789',N'95 Trần Khắc Chân, huyện Cẩm Giàng, Nam Định','2005-02-21')
INSERT INTO KhachHang VALUES('KH0015',N'Nguyễn Hà Long','0912321311',N'211,Tỉnh lộ 8,Long An','1991-01-11')
INSERT INTO KhachHang VALUES('KH0016',N'Hà Thị Thu Hà','0123456231',N'244 Lạc Long Quân, Quận 10,TPHCM','1997-01-20')
INSERT INTO KhachHang VALUES('KH0017',N'Đặng Quyền Anh','0123098789',N'Đồng Tháp','1991-01-10')
INSERT INTO KhachHang VALUES('KH0018',N'Hà Tất Long','0123987654',N'101,Nguyễn Oanh,Gò Vấp,TPHCM','2001-09-10')
INSERT INTO KhachHang VALUES('KH0019',N'Đào Duy Lân','0987654321',N'100,Lạc Long Quân,Quận 11,TPHCM','2000-10-05')
INSERT INTO KhachHang VALUES('KH0020',N'Nguyễn Thu Loan','0971654231',N'19,Nguyễn Văn Bảo,Gò Vấp,TPHCM','2020-01-20')
INSERT INTO KhachHang VALUES('KH0021',N'Trần Tiến Đạt','0932351112',N'16 Tôn Thất Thuyết, Quận 5, TPHCM','1997-04-10')
INSERT INTO KhachHang VALUES('KH0022',N'Phan Thị Ngọc Dung','0961444323',N'512 Phan Văn Trị, Quận Gò Vấp, TPHCM','1995-07-22')
INSERT INTO KhachHang VALUES('KH0023',N'Trần Hiếu Nghĩa','081234452162',N'128 Bà Triệu, Gò Dầu, Tây Ninh','1991-12-07')
INSERT INTO KhachHang VALUES('KH0024',N'Nguyễn Phương Thanh','072511224940',N'22 Điện Biên Phủ, Quận 10, TPHCM','1997-02-12')

-- Ghe
--PHòng A
insert into Ghe values('A0001',1)
insert into Ghe values('A0002',1)
insert into Ghe values('A0003',1)
insert into Ghe values('A0004',1)
insert into Ghe values('A0005',1)
insert into Ghe values('A0006',1)
insert into Ghe values('A0007',1)
insert into Ghe values('A0008',1)
insert into Ghe values('A0009',1)
insert into Ghe values('A0010',1)
insert into Ghe values('A0011',1)
insert into Ghe values('A0012',0)
insert into Ghe values('A0013',1)
insert into Ghe values('A0014',1)
insert into Ghe values('A0015',1)
insert into Ghe values('A0016',1)
insert into Ghe values('A0017',1)
insert into Ghe values('A0018',1)
insert into Ghe values('A0019',1)
insert into Ghe values('A0020',1)
insert into Ghe values('A0021',1)
insert into Ghe values('A0022',1)
insert into Ghe values('A0023',1)
insert into Ghe values('A0024',1)
insert into Ghe values('A0025',1)
insert into Ghe values('A0026',1)
insert into Ghe values('A0027',1)
insert into Ghe values('A0028',1)
insert into Ghe values('A0029',1)
insert into Ghe values('A0030',1)
--phong B
insert into Ghe values('B0001',1)
insert into Ghe values('B0002',1)
insert into Ghe values('B0003',1)
insert into Ghe values('B0004',1)
insert into Ghe values('B0005',1)
insert into Ghe values('B0006',1)
insert into Ghe values('B0007',1)
insert into Ghe values('B0008',1)
insert into Ghe values('B0009',1)
insert into Ghe values('B0010',1)
insert into Ghe values('B0011',1)
insert into Ghe values('B0012',1)
insert into Ghe values('B0013',1)
insert into Ghe values('B0014',1)
insert into Ghe values('B0015',1)
insert into Ghe values('B0016',1)
insert into Ghe values('B0017',1)
insert into Ghe values('B0018',1)
insert into Ghe values('B0019',1)
insert into Ghe values('B0020',1)
insert into Ghe values('B0021',1)
insert into Ghe values('B0022',1)
insert into Ghe values('B0023',1)
insert into Ghe values('B0024',1)
insert into Ghe values('B0025',1)
insert into Ghe values('B0026',1)
insert into Ghe values('B0027',1)
insert into Ghe values('B0028',1)
insert into Ghe values('B0029',1)
insert into Ghe values('B0030',1)
--PhongC
insert into Ghe values('C0001',1)
insert into Ghe values('C0002',1)
insert into Ghe values('C0003',1)
insert into Ghe values('C0004',1)
insert into Ghe values('C0005',1)
insert into Ghe values('C0006',1)
insert into Ghe values('C0007',1)
insert into Ghe values('C0008',1)
insert into Ghe values('C0009',1)
insert into Ghe values('C0010',1)
insert into Ghe values('C0011',1)
insert into Ghe values('C0012',1)
insert into Ghe values('C0013',1)
insert into Ghe values('C0014',1)
insert into Ghe values('C0015',1)
insert into Ghe values('C0016',1)
insert into Ghe values('C0017',1)
insert into Ghe values('C0018',1)
insert into Ghe values('C0019',1)
insert into Ghe values('C0020',1)
insert into Ghe values('C0021',1)
insert into Ghe values('C0022',1)
insert into Ghe values('C0023',1)
insert into Ghe values('C0024',1)
insert into Ghe values('C0025',1)
insert into Ghe values('C0026',1)
insert into Ghe values('C0027',1)
insert into Ghe values('C0028',1)
insert into Ghe values('C0029',1)
insert into Ghe values('C0030',1)
--phongD
insert into Ghe values('D0001',1)
insert into Ghe values('D0002',1)
insert into Ghe values('D0003',1)
insert into Ghe values('D0004',1)
insert into Ghe values('D0005',1)
insert into Ghe values('D0006',1)
insert into Ghe values('D0007',1)
insert into Ghe values('D0008',1)
insert into Ghe values('D0009',1)
insert into Ghe values('D0010',1)
insert into Ghe values('D0011',1)
insert into Ghe values('D0012',1)
insert into Ghe values('D0013',1)
insert into Ghe values('D0014',1)
insert into Ghe values('D0015',1)
insert into Ghe values('D0016',1)
insert into Ghe values('D0017',1)
insert into Ghe values('D0018',1)
insert into Ghe values('D0019',1)
insert into Ghe values('D0020',1)
insert into Ghe values('D0021',1)
insert into Ghe values('D0022',1)
insert into Ghe values('D0023',1)
insert into Ghe values('D0024',1)
insert into Ghe values('D0025',1)
insert into Ghe values('D0026',1)
insert into Ghe values('D0027',1)
insert into Ghe values('D0028',1)
insert into Ghe values('D0029',1)
insert into Ghe values('D0030',1)

-- Dang Chieu
insert into DangChieu values('DC1',N'Chiếu 2D')
insert into DangChieu values('DC2',N'Chiếu 3D')

-- LoaiVe 
insert into LoaiVe values('LV1',N'Vé thường',50000)
insert into LoaiVe values('LV2',N'Vé Couple',100000)

-- LoaiPhim 
INSERT INTO LoaiPhim VALUES('PHanhDong',N'Phim hành động')
INSERT INTO LoaiPhim VALUES('PPhieuLuu',N'Phim phiêu lưu')
INSERT INTO LoaiPhim VALUES('PKhoaHocVT',N'Phim khoa học viễn tưởng')
INSERT INTO LoaiPhim VALUES('PHaiKich',N'Phim hài kịch')
INSERT INTO LoaiPhim VALUES('PKinhDi',N'Phim kinh dị')
INSERT INTO LoaiPhim VALUES('PHoatHinh',N'Phim hoạt hình')
INSERT INTO LoaiPhim VALUES('PLangMan',N'Phim lãng mạn')
INSERT INTO LoaiPhim VALUES('PLichSu',N'Phim lịch sử')
INSERT INTO LoaiPhim VALUES('PTaiLieu',N'Phim tài liệu')

-- PhongChieu
INSERT INTO PhongChieu VALUES('A',N'Phòng A',30,'Phòng sạch, rộng rãi thoáng mát, có máy lạnh điều hoà')
INSERT INTO PhongChieu VALUES('B',N'Phòng B',30,'Âm thanh sống động, có máy lạnh điều hoà')
INSERT INTO PhongChieu VALUES('C',N'Phòng C',30,'Phòng sạch, rộng rãi thoáng mát, trang thiết bị tiên tiến')
INSERT INTO PhongChieu VALUES('D',N'Phòng D',30,'Phòng sạch, rộng rãi thoáng mát, có máy lạnh điều hoà')

-- NhanVien
INSERT INTO NhanVien VALUES('NV001', N'Trần Đỗ Đăng Khánh', '0399026084', '0823423223', 'LNV001')
INSERT INTO NhanVien VALUES('NV002', N'Lưu Ngọc Cao Sơn', '0902689023', '0823423453', 'LNV001')
INSERT INTO NhanVien VALUES('NV003', N'Nguyễn Tấn Phát', '0743534333', '0823542573', 'LNV002')
INSERT INTO NhanVien VALUES('NV004', N'Nguyễn Trung Quyền', '0980909099', '0889986231', 'LNV002')
INSERT INTO NhanVien VALUES('NV005', N'Võ Thanh Phong', '0927723553', '0888890809', 'LNV001')
INSERT INTO NhanVien VALUES('NV006', N'Nguyễn Thành Luân', '0399026888', '0823422321', 'LNV001')

-- HoaDon 
--INSERT INTO HoaDon VALUES('HD001','KH0001','2024-03-10','NV001')
--INSERT INTO HoaDon VALUES('HD002','KH0001','2024-03-10','NV002')
--INSERT INTO HoaDon VALUES('HD003','KH0002','2024-04-18','NV003')
--INSERT INTO HoaDon VALUES('HD004','KH0002','2024-04-18','NV004')
--INSERT INTO HoaDon VALUES('HD005','KH0002','2024-04-10','NV004')
--INSERT INTO HoaDon VALUES('HD006','KH0009','2024-03-10','NV004')
--INSERT INTO HoaDon VALUES('HD007','KH0007','2020-10-10','NV006')
--INSERT INTO HoaDon VALUES('HD008','KH0010','2023-06-21','NV006')
--INSERT INTO HoaDon VALUES('HD009','KH0022','2022-05-11','NV006')

-- Phim 
INSERT INTO Phim VALUES('P01',N'Doraemon',50000,'PHoatHinh','DC1')
INSERT INTO Phim VALUES('P03',N'Kung Fu Panda 4',1200000,'PHoatHinh','DC1')
INSERT INTO Phim VALUES('P05',N'Điềm Báo Của Quỷ',150000,'PKinhDi','DC1')
INSERT INTO Phim VALUES('P07',N'Biệt Đội Săn Ma',130000,'PHaiKich','DC1')
INSERT INTO Phim VALUES('P09',N'Thần Bài Trở Lại',70000,'PHanhDong','DC1')

INSERT INTO Phim VALUES('P02',N'Muôn Vị Nhân Gian',50000,'PLangMan','DC2')
INSERT INTO Phim VALUES('P04',N'Đào Và Piano',60000,'PLichSu','DC2')
INSERT INTO Phim VALUES('P06',N'TĐóa Hoa Mong Manh',80000,'PTaiLieu','DC2')
INSERT INTO Phim VALUES('P08',N'Kamen Rider Faiz 20th Anniversary ',90000,'PKhoaHocVT','DC2')
INSERT INTO Phim VALUES('P010',N'OverLord Holy Kingdom',100000,'PHoatHinh','DC2')

--LichChieu
INSERT INTO LichChieu VALUES('LC01','9:30:00','11:00:00','2024-04-13','A','P01')
INSERT INTO LichChieu VALUES('LC02','13:30:00','16:00:00','2024-04-13','D','P07')
INSERT INTO LichChieu VALUES('LC03','10:15:00','12:15:00','2023-07-05','A','P02')
INSERT INTO LichChieu VALUES('LC04','8:30:00','11:15:00','2024-02-25','B','P03')
INSERT INTO LichChieu VALUES('LC05','18:30:00','20:20:00','2023-11-15','B','P05')
INSERT INTO LichChieu VALUES('LC06','9:30:00','11:00:00','2023-08-18','B','P09')
INSERT INTO LichChieu VALUES('LC07','16:30:00','18:00:00','2024-02-20','C','P01')
INSERT INTO LichChieu VALUES('LC08','18:00:00','20:45:00','2024-12-13','D','P04')
INSERT INTO LichChieu VALUES('LC09','6:30:00','9:00:00','2023-09-27','C','P08')
INSERT INTO LichChieu VALUES('LC010','15:30:00','17:00:00','2023-11-18','A','P010')
INSERT INTO LichChieu VALUES('LC011','8:30:00','10:00:00','2024-01-19','D','P05')

--VePhim 
--INSERT INTO VePhim VALUES ('V000001','LV2','P9','LC6','A0012',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000002','LV1','P9','LC6','A0011',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000003','LV1','P9','LC6','A0013',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000004','LV2','P9','LC6','A0014',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000005','LV1','P9','LC6','A0015',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000006','LV1','P9','LC6','A0016',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000007','LV2','P9','LC6','A0017',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000008','LV2','P9','LC6','A0018',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000009','LV1','P9','LC6','A0019',90000.0,N'Không có mô tả')
--INSERT INTO VePhim VALUES ('V000010','LV1','P9','LC6','A0020',90000.0,N'Không có mô tả')

--ChiTietHoaDon
--INSERT INTO ChiTietHoaDon VALUES('V000001', 'HD001', 5,'2024-04-13')
--INSERT INTO ChiTietHoaDon VALUES('V000002', 'HD001', 5,'2024-04-13')
--INSERT INTO ChiTietHoaDon VALUES('V000003', 'HD001', 5,'2024-04-13')
--INSERT INTO ChiTietHoaDon VALUES('V000004', 'HD001', 5,'2024-04-13')






