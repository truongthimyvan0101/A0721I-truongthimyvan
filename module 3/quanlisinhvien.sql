create database thi_ket_thuc_module;
use thi_ket_thuc_module;
create table mat_bang_thue(
 ma_mat_bang  int NOT NULL AUTO_INCREMENT,
 dien_tich double,
  trang_thai varchar(120),
 tang int,
 loai_van_phong varchar(120),
 gia_tien double,
 ngay_bat_dau varchar(120),
 ngay_ket_thuc varchar(120),
primary key(ma_mat_bang)
);

insert into mat_bang_thue(dien_tich,trang_thai,tang,
loai_van_phong,gia_tien,ngay_bat_dau,ngay_ket_thuc) values (100,"Trống",2,"Cho thue",2000000,"20/11/2020","25/11/2021");

insert into mat_bang_thue(dien_tich,trang_thai,tang,
loai_van_phong,gia_tien,ngay_bat_dau,ngay_ket_thuc)
 values (200,"Trống",5,"Tron gói",5000000,"03/04/2020","30/10/2021");
 
 select*from mat_bang_thue;