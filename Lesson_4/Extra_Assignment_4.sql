-- Question 1: Lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'
SELECT `Name`
FROM Product
WHERE ProductSubcategoryID IN (
    SELECT ProductSubcategoryID
    FROM ProductSubcategory
    WHERE `Name` = 'Saddles'
);

-- Question 2: Thay đổi câu Query 1 với wildcard 'Bo%'
SELECT `Name`
FROM Product
WHERE ProductSubcategoryID IN (
    SELECT ProductSubcategoryID
    FROM ProductSubcategory
    WHERE `Name` LIKE 'Bo%'
);

-- Question 3: Lấy sản phẩm có giá rẻ nhất và ProductSubcategoryID = 3 (Touring Bike)
SELECT `Name`
FROM Product
WHERE ProductSubcategoryID = 3
AND ListPrice = (
    SELECT MIN(ListPrice)
    FROM Product
    WHERE ProductSubcategoryID = 3
);

-- Question 1: Lấy danh sách tên country và province
SELECT 
    c.`Name` AS Country,
    sp.`Name` AS Province
FROM CountryRegion c
JOIN StateProvince sp ON c.CountryRegionCode = sp.CountryRegionCode;

-- Question 2: Chỉ lấy country Germany và Canada
SELECT 
    c.`Name` AS Country,
    sp.`Name` AS Province
FROM CountryRegion c
JOIN StateProvince sp ON c.CountryRegionCode = sp.CountryRegionCode
WHERE c.`Name` IN ('Germany', 'Canada');

-- Question 3: JOIN SalesOrderHeader và SalesPerson (non-Internet orders only)
SELECT 
    soh.SalesOrderID,
    soh.OrderDate,
    soh.SalesPersonID,
    sp.SalesPersonID AS BusinessEntityID, 
    sp.Bonus,
    sp.SalesYTD
FROM SalesOrderHeader soh
JOIN SalesPerson sp ON soh.SalesPersonID = sp.SalesPersonID
WHERE soh.OnlineOrderFlag = 0  
AND soh.SalesPersonID IS NOT NULL;

-- Question 4: Sử dụng câu query ở question 3, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID
SELECT 
    soh.SalesOrderID,
    soh.OrderDate,
    e.Title AS JobTitle,  
    sp.Bonus,
    sp.SalesYTD
FROM SalesOrderHeader soh
JOIN SalesPerson sp ON soh.SalesPersonID = sp.SalesPersonID
JOIN Employee e ON sp.SalesPersonID = e.EmployeeID
WHERE soh.OnlineOrderFlag = 0 
AND soh.SalesPersonID IS NOT NULL;
