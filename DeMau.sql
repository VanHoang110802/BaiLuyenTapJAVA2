CREATE DATABASE MOB1024_DeMau;
GO
USE MOB1024_DeMau;
CREATE TABLE san_pham (
    id        INT IDENTITY(1,1) PRIMARY KEY,
    ten_san_pham    NVARCHAR(100) NOT NULL,
    loai_san_pham   NVARCHAR(50)  NOT NULL,
    so_luong  INT NOT NULL
);
GO
INSERT INTO san_pham (ten_san_pham, loai_san_pham, so_luong)
VALUES
    (N'Áo thun nam',     N'Thời trang', 150),
    (N'Quần jeans nữ',   N'Thời trang',  80),
    (N'Giày thể thao',   N'Giày dép',   200);
GO