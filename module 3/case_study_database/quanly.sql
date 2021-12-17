create database quanlyfuramaresort;
use quanlyfuramaresort;

create table vitri(
	IDViTri int primary key auto_increment,
    TenVitri varchar(45)
);

create table bophan(
	IDBoPhan int primary key auto_increment,
    TenBoPhan varchar(45)
);

create table trinhdo(
	IDTrinhDo int primary key auto_increment,
    TrinhDo varchar(45)
);

create table nhanvien(
	IDNhanVien int primary key auto_increment,
    HoTen varchar(45),
    IDViTri int,
    IDTrinhDo int,
    IDBoPhan int,
    NgaySinh date,
    SoCMND varchar(45),
    Luong varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    foreign key(IDViTri) references vitri(IDViTri),
    foreign key(IDTrinhDo) references trinhdo(IDTrinhDo),
    foreign key(IDBoPhan) references bophan(IDBoPhan)
);

create table loaikhach(
	IDLoaiKhach int primary key auto_increment,
    TenLoaiKhach varchar(45)
);

create table khachhang(
	IDKhachHang int primary key auto_increment,
    IDLoaiKhach int,
    HoTen varchar(45),
    NgaySinh date,
    SoCMND varchar(45),
    SDT varchar(45), 
    Email varchar(45),
    Address varchar(45),
    foreign key(IDLoaiKhach) references loaikhach(IDLoaiKhach)
);

create table kieuthue(
	IDKieuThue int primary key auto_increment,
    TenKieuThue varchar(45),
    Gia int
);

create table loaidichvu(
	IDLoaiDichVu int primary key auto_increment,
    TenLoaiDichVu varchar(45)
);

create table dichvu(
	IDDichVu int primary key auto_increment,
    TenDichVu varchar(45) not null,
    DienTich int,
    SoTang int,
    SoNguoiToiDa varchar(45),
    ChiPhiThue varchar(45),
    IDKieuThue int,
    IDLoaiDichVu int,
    TrangThai varchar(45),
    foreign key(IDKieuThue) references kieuthue(IDKieuThue),
    foreign key(IDLoaiDichVu) references loaidichvu(IDLoaiDichVu)
);

create table hopdong(
	IDHopDong int primary key auto_increment,
    IDNhanVien int,
    IDKhachHang int,
    IDDichVu int,
    NgayLamHopDong date not null,
    NgayKetThucHopDong date not null,
    TienDatCoc varchar(50) not null,
    TongTien varchar(50) not null,
    foreign key(IDNhanVien) references nhanvien(IDNhanVien),
    foreign key(IDKhachHang) references khachhang(IDKhachHang),
    foreign key(IDDichVu) references dichvu(IDDichVu)
);

create table dichvudikem(
	IDDichVuDiKem int primary key auto_increment,
    TenDichVuDiKem varchar(45),
    Gia int,
    DonVi int,
    TrangThaiKhaDung varchar(45)
);

create table hopdongchitiet(
	IDHopDongChiTiet int primary key auto_increment,
    IDHopDong int,
    IDDichVuDiKem int,
    SoLuong int,
    foreign key(IDDichVuDiKem) references dichvudikem(IDDichVuDiKem),
    foreign key(IDHopDong) references hopdong(IDHopDong)
);
-- 1. Thêm dữ liệu
insert into bophan(IDBoPhan, TenBoPhan) values
(1, "Nhân sự"),
(2, "Kinh doanh"),
(3, "Dịch vụ phòng"),
(4, "Kế toán"),
(5, "Kỹ thuật"),
(6, "Ẩm thực"),
(7, "An ninh"),
(8, "Giải trí"),
(9, "Thể thao");
insert into bophan value(10, "Lễ tân");

insert into trinhdo(IDTrinhDo, TrinhDo) values
(1, "THPT"),
(2, "CD"),
(3, "DH"),
(4, "CH"),
(5, "TS");

insert into vitri(IDViTri, TenViTri) values
(1, "Tuyển dụng"),
(2, "Huấn luyện"),
(3, "marketing"),
(4, "Giám đốc lễ tân"),
(5, "Nhân viên lễ tân"),
(6, "Nhân viên quan hệ khách hàng"),
(7, "Nhân viên thu ngân"),
(8, "Nhân viên hành lý"),
(9, "Nhân viên hỗ trợ khách hàng"),
(10, "Nhân viên kiểm toán đêm"),
(11, "Nhân viên đặt phòng"),
(12, "Nhân viên trực tổng đài"),
(13, "Nhân viên đội xe"),
(14, "Nhân viên quầy lưu niệm"),
(15, "Giám đốc buồng phòng"),
(16, "Nhân viên làm phòng"),
(17, "Vệ sinh công cộng"),
(18, "Kho"),
(19, "Làm vườn"),
(20, "Trông trẻ"),
(21, "Giám đốc kinh doanh"),
(22, "Giám đốc tuyển dụng"),
(23, "Giám đốc tài chính"),
(24, "Nhân viên kế toán"),
(25, "Giám đốc kỹ thuật"),
(26, "Nhân viên bảo trì"),
(27, "Giám đốc ẩm thực"),
(28, "Giám đốc nhà hàng"),
(29, "Bếp trưởng"),
(30, "Phục vụ nhà hàng âu"),
(31, "Bếp âu"),
(32, "Phục vụ nhà hàng việt");
insert into vitri(IDViTri, TenViTri) values
(33, "Phục vụ nhà hàng á"),
(34, "Bếp á"),
(35, "Phục vụ nhà hàng hoa"),
(36, "Bếp hoa");
insert into vitri(IDViTri, TenViTri) values
(37, "Trưởng bộ phận bar"),
(38, "Phục vụ bộ phận bar"),
(39, "Giám đốc an ninh"),
(40, "Nhân viên bảo vệ"),
(41, "Giám đốc giải trí"),
(42, "Nhân viên giải trí"),
(43, "Giám đốc thể thao"),
(44, "Nhân viên thể thao"),
(45, "Bếp việt"),
(46, "Bếp bánh");

insert into nhanvien(IDNhanVien, HoTen, IDViTri, IDTrinhDo, IDBoPhan, NgaySinh, SoCMND, Luong, SDT, Email, DiaChi) values
(1, "Trương Thị Mỹ Vân", 1, 1, 1, "2000-01-01", "123987768", "10000000", "0128682983", "van@gmail.com", "Quảng Ngãi"),
(2, "Trần Công Toản", 2, 2, 1, "1998-09-12", "123987568", "12000000", "0128492983", "toan@gmail.com", "Quảng Nam"),
(3, "Lê Phước Tiến", 3, 3, 2, "1999-06-14", "123987768", "13000000", "0129382983", "Tien@gmail.com", "Đà Nẵng"),
(4, "Nguyễn Văn B", 4, 4, 3, "2000-11-20", "123987018", "10000000", "0128413983", "B123@gmail.com", "Đà Nẵng"),
(5, "Đào Văn C", 5, 5, 3, "2000-01-11", "123980968", "17000000", "0120982983", "C123@gmail.com", "Quảng Nam"),
(6, "Phạm Thị Thu Thảo", 6, 1, 3, "1999-06-08", "198987768", "9000000", "0145682983", "Thao@gmail.com", "Quảng ngãi"),
(7, "Nguyễn Văn A", 7, 2, 3, "1999-10-27", "124487768", "12300000", "0128601983", "A123@gmail.com", "Huế"),
(8, "Trần Văn An", 8, 3, 3, "1992-11-02", "343987768", "8000000", "0224682983", "An@gmail.com", "Quảng Nam"),
(9, "Nguyễn Thị Ánh", 9, 4, 3, "1996-11-02", "984987768", "11000000", "0344656983", "Anh123@gmail.com", "Quảng Nam"),
(10, "Trần Thị Thảo", 10, 5, 3, "1991-10-27", "873987768", "10000000", "0109682983", "thao@gmail.com", "Hà Tĩnh");

insert into nhanvien(IDNhanVien, HoTen, IDViTri, IDTrinhDo, IDBoPhan, NgaySinh, SoCMND, Luong, SDT, Email, DiaChi) values
(11, "Trần Lê Văn", 20, 1, 1, "1994-12-12", "345234653", "15000000", "0984297852", "Van@gmail.com", "Đà Nẵng");

insert into loaikhach(IDLoaiKhach, TenLoaiKhach) values
(1,"Diamond"),
(2, "Platinium"),
(3, "Gold"),
(4, "Silver"),
(5, "Member");

insert into khachhang(IDKhachHang, IDLoaiKhach, HoTen, NgaySinh, SoCMND, SDT, Email, Address) values
(1, 1, "Nguyễn Thị A", "2000-12-09", "979843871", "0879289462", "A2000@gmail.com", "Quảng Nam"),
(2, 2, "Trần Văn Xuân", "2001-08-02", "979843871", "0479689462", "Xuan@gmail.com", "Quảng Ngãi"),
(3, 3, "Lại Thị Diễm", "2003-02-05", "979840981", "0989289462", "Diem@gmail.com", "Đà Nẵng"),
(4, 4, "Ngô Hoàng Anh", "1998-03-04", "984843871", "0987389462", "Anh@gmail.com", "Gia Lai"),
(5, 5, "Trần Minh Tuấn", "1993-05-07", "098843871", "0934889462", "tuan@gmail.com", "Quảng Ngãi"),
(6, 6, "Lại Xuân Tạo", "1999-04-02", "909843871", "0825289462", "tao@gmail.com", "Quảng Ngãi"),
(7, 7, "Trần Văn Huy", "2000-08-04", "979898371", "0870989462", "huy@gmail.com", "Đà Nẵng"),
(8, 8, "Đoàn Tuấn Mạnh", "1990-09-29", "123843871", "0989289462", "manh123@gmail.com", "Quảng Nam");
insert into khachhang(IDKhachHang, IDLoaiKhach, HoTen, NgaySinh, SoCMND, SDT, Email, Address) values
(9, 9, "Trương Thị Phi", "1997-02-02", "974873193", "0123947861", "Phi@gmail.com", "Quảng Ngãi"),
(10, 10, "Trương Thị My", "1997-11-02", "983873193", "0198347861", "vu@gmail.com", "Quảng Ngãi");


insert into loaidichvu(IDLoaiDichVu, TenLoaiDichVu) values
(1, "Dịch vụ cơ bản"),
(2, "Dịch vụ cao cấp"),
(3, "Dịch vụ bình dân");

insert into kieuthue(IDKieuThue, TenKieuThue, Gia) values
(1, "Chất lượng thấp", 300000),
(2, "Bình thường", 500000),
(3, "Chất lượng cao", 1000000);

insert into dichvu(IDDichVu, TenDichVu, DienTich, SoTang, SoNguoiToiDa, ChiPhiThue, IDKieuThue, IDLoaiDichVu, TrangThai) values
(1, "villa", 30, 3, 7, 7000000, 3,2,1),
(2, "house", 40, 3, 8, 8000000, 3, 2, 1),
(3, "room", 30, 1, 3, 2500000, 3, 2, 1);

update dichvu set dichvu.TenDichVu = "room", dichvu.ChiPhiThue = 2500000
where dichvu.IDDichVu = 3;

insert into hopdong(IDHopDong, IDNhanVien, IDKhachHang, IDDichVu, NgayLamHopDong, NgayKetThucHopDong, TienDatCoc, TongTien) values
(1, 1, 1, 1, "2021-12-13", "2021-12-28", 2000000, 10000000),
(2, 2, 2, 2, "2021-12-15", "2021-12-29", 3000000, 12000000),
(3, 3, 3, 3, "2021-12-16", "2021-12-30", 1000000, 8000000);
insert into hopdong(IDHopDong, IDNhanVien, IDKhachHang, IDDichVu, NgayLamHopDong, NgayKetThucHopDong, TienDatCoc, TongTien) values
(4, 4, 4, 4, "2021-12-13", "2021-12-25", 800000, 6000000),
(5, 5, 5, 5, "2021-12-14", "2021-12-26", 900000, 7000000),
(6, 6, 6, 6, "2021-12-21", "2021-12-27", 1000000, 8000000);
insert into hopdong(IDHopDong, IDNhanVien, IDKhachHang, IDDichVu, NgayLamHopDong, NgayKetThucHopDong, TienDatCoc, TongTien) values
(7, 7, 7, 7, "2021-12-21", "2021-12-30", 1000000, 8000000),
(8, 8, 8, 8, "2021-12-21", "2021-12-30", 1000000, 8000000),
(9, 9, 9, 9, "2021-12-21", "2021-12-30", 1000000, 8000000);
insert into hopdong(IDHopDong, IDNhanVien, IDKhachHang, IDDichVu, NgayLamHopDong, NgayKetThucHopDong, TienDatCoc, TongTien) values
(10, 10, 10, 10, "2021-12-21", "2021-12-25", 1000000, 8000000);

update hopdong set NgayLamHopDong = "2021-12-13" where IDHopDong = 4;
update hopdong set NgayLamHopDong = "2021-12-14" where IDHopDong = 5;
update hopdong set NgayLamHopDong = "2021-12-21" where IDHopDong = 6;

insert into dichvudikem(IDDichVuDiKem, TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values
(1, "Dịch vụ giặc ủi", 500000, 1, 1),
(2, "Dich vụ đưa đón", 700000, 2, 1),
(3, "Dịch vụ casino", 5000000, 3, 1),
(4, "Dịch vụ Trông trẻ", 2000000, 4, 1),
(5, "Dịch vụ ăn sáng", 200000, 5, 1);
insert into hopdongchitiet(IDHopDongChiTiet, IDHopDong, IDDichVuDiKem, SoLuong) values
(1, 1, 1, 1),
(2, 2, 2, 3),
(3, 3, 3, 4),
(4, 4, 4, 4),
(5, 5, 5, 6),
(6, 6, 1, 3),
(7, 7, 2, 1),
(8, 8, 3, 3),
(9, 9, 4, 7),
(10, 10, 5, 1),
(11, 11, 1, 2),
(12, 12, 2, 8);
insert into hopdongchitiet(IDHopDongChiTiet, IDHopDong, IDDichVuDiKem, SoLuong) values
(13, 13, 1, 2),
(14, 14, 2, 3),
(15, 15, 3, 1),
(16, 16, 4, 3);
-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhanvien
where (HoTen like "% H%" or HoTen like "% T%" or HoTen like "% K%"); 
-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khachhang
where (year(localtime())-year(NgaySinh) >= 18 and year(localtime())-year(NgaySinh) <=50) and
(Address = "Đà Nẵng" or Address = "Quảng Trị");
-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select khachhang.IDKhachHang, khachhang.HoTen, khachhang.Email, count(hopdong.IDKhachHang) as SoLan from khachhang
join loaikhach on loaikhach.IDLoaiKhach = khachhang.IDLoaiKhach
join hopdong on hopdong.IDKhachHang = khachhang.IDKhachHang
where loaikhach.IDLoaiKhach = 1
group by hopdong.IDKhachHang
order by SoLan;
-- 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
-- cho tất cả các Khách hàng đã từng đặt phòng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select khachhang.IDKhachHang, khachhang.HoTen, loaikhach.TenLoaiKhach, hopdong.IDHopDong, dichvu.TenDichVu,
hopdong.NgayLamHopDong, hopdong.NgayKetThucHopDong, sum(ChiPhiThue + (hopdongchitiet.SoLuong*dichvudikem.Gia)) as TongTien from khachhang
left join hopdong on hopdong.IDKhachHang = khachhang.IDKhachHang
left join hopdongchitiet on hopdongchitiet.IDHopDong = hopdong.IDHopDong
left join dichvudikem on dichvudikem.IDDichVuDiKem = hopdongchitiet.IDDichVuDiKem
left join loaikhach on loaikhach.IDLoaiKhach = khachhang.IDLoaiKhach
left join dichvu on dichvu.IDDichVu = hopdong.IDDichVu
group by hopdong.IDKhachHang;
-- 6. Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ
-- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dichvu.IDDichVu, dichvu.TenDichVu, dichvu.DienTich, dichvu.ChiPhiThue, loaidichvu.TenLoaiDichVu from dichvu
join loaidichvu on loaidichvu.IDLoaiDichVu = dichvu.IDLoaiDichVu
where dichvu.IDDichVu not in(
	select hopdong.IDDichVu from hopdong
    where(
		(month(hopdong.NgayLamHopDong) = 1 or month(hopdong.NgayLamHopDong) = 2 or month(hopdong.NgayLamHopDong) = 3)
        and year(hopdong.NgayLamHopDong) = 2019
	)
);
-- 7. Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select dichvu.IDDichVu, dichvu.TenDichVu, dichvu.DienTich, dichvu.SoNguoiToiDa, dichvu.ChiPhiThue, loaidichvu.TenLoaiDichVu from dichvu
join loaidichvu on loaidichvu.IDLoaiDichVu = dichvu.IDLoaiDichVu
where ((dichvu.IDDichVu in (select hopdong.IDDichVu from hopdong where year(hopdong.NgayLamHopDong) = 2018)) and
	(dichvu.IDDichVu not in (select hopdong.IDDichVu from hopdong where year(hopdong.NgayLamHopDong) = 2019))
);
-- 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
select distinct khachhang.HoTen from khachhang;

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select year(hopdong.NgayLamHopDong) as Nam, month(hopdong.NgayLamHopDong) as Thang, count(hopdong.IDKhachHang) as SoLuong from hopdong 
join khachhang on khachhang.IDKhachHang = hopdong.IDKhachHang
group by Nam, Thang
order by Nam, Thang;

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.IDHopDong, hopdong.NgayLamHopDong, hopdong.NgayKetThucHopDong,
hopdong.TienDatCoc, hopdongchitiet.SoLuong from hopdong
join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong;
-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
-- TenLoaiKhachHang là “Diamond” và có địa chỉ là “Quảng Nam” hoặc “Quảng Ngãi”.
select dichvudikem.IDDichVuDiKem, dichvudikem.TenDichVuDiKem, dichvudikem.Gia, khachhang.HoTen, khachhang.Address, loaikhach.TenLoaiKhach from dichvudikem
join hopdongchitiet on hopdongchitiet.IDDichVuDiKem = dichvudikem.IDDichVuDiKem
join hopdong on hopdong.IDHopDong = hopdongchitiet.IDHopDong
join khachhang on khachhang.IDKhachHang = hopdong.IDKhachHang
join loaikhach on loaikhach.IDLoaiKhach = khachhang.IDLoaiKhach
where loaikhach.IDLoaiKhach = 1 and (khachhang.Address = "Quảng Nam" or khachhang.Address = "Quảng Ngãi");


