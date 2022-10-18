# learn 1 
class yang digunakan untuk membuat table dengan yg digunakan untuk menerima object di /register itu class yg sama. problemnya ketika buat validitas untuk password, misal buat validitas/constraint panjang password max 20. ketika proses validatas di /register gk akan ada masalah. tapi validitas ini juga dilakukan ke table, padahal ketika dimasukan ke table password di encode sehingga panjangnya lebih dari 20, hal ini akan menyebabkan ConstraintViolationException.




# links 
* [](https://stackoverflow.com/questions/52494459/responseentity-and-responseentity-are-not-the-same)