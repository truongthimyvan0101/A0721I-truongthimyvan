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


