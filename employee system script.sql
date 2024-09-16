CREATE DATABASE employeeMangementSystem;

USE employeeMangementSystem

CREATE TABLE employees (
    id INT IDENTITY(1001, 1) PRIMARY KEY,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
	address VARCHAR(50),
	phone VARCHAR(15),
	email VARCHAR(30),
    position VARCHAR(10) CHECK (position IN ('ADMIN', 'HR', 'EMPLOYEE')) DEFAULT 'EMPLOYEE',
    salary DEC(8, 2) DEFAULT 0
);


INSERT INTO employees VALUES
('Omar', 'Mohamed', '23 AboOmer str', '98534221670', 'omar.mohamed@gmail.com', 'ADMIN', 68000),
('Mostafa', 'Mohamed', '26 ElMostafa str', '52469852137', 'mostafa.mohamed@gmail.com', 'HR', 25000),
('Hamza', 'Osama', 'ElHamzawi_str', '88520011367', 'hamza.osama@gmail.com', 'EMPLOYEE', 14000),
('AbdulRahman', 'Medhat', '13 Elto7a str', '96321548230', 'abdulrahman.medhat@gmail.com', 'ADMIN', 50000),
('Mahmoud', 'Ezzat', 'Abo el3ez str', '11122233354', 'mahmoud.ezzat@gmail.com', 'ADMIN', 45000),
('Eslam', 'Nagm', 'Sun street', '00001112548', 'eslam.nagm@gmail.com', 'EMPLOYEE', 20000),
('Mohamed', 'Fathi', 'Al ftah str', '58946321789', 'mohamed.fathi@gmail.com', 'ADMIN', 45000),
('Mohamed', 'Mansour', 'Street', '0005298956', 'mohamed.mansour@gmail.com', 'EMPLOYEE', 50000),
('AbdulRahman', 'Ezzat', 'el rhmany str', '489653215785', 'abdulrahman.ezzat@gmail.com', 'EMPLOYEE', 70000),
('Marwan', 'Zen', 'elzenawi str', '89562134756', 'marwan.zen@gmail.com', 'EMPLOYEE', 25000),
('Ahmed', 'Al-Farsi', '123 Al-Farsi St, Riyadh', '123456789', 'ahmed.farsi@gmail.com', 'ADMIN', 70000),
('Omar', 'Al-Saleh', '456 Al-Saleh St, Jeddah', '234567890', 'omar.saleh@gmail.com', 'ADMIN', 68000),
('Fatima', 'Al-Hassan', '789 Al-Hassan St, Dammam', '345678901', 'fatima.hassan@gmail.com', 'ADMIN', 72000),
('Ali', 'Mohamed', '101 Mohamed St, Mecca', '456789012', 'ali.mohamed@gmail.com', 'HR', 45000),
('Khalid', 'Ibrahim', '102 Ibrahim St, Medina', '567890123', 'khalid.ibrahim@gmail.com', 'HR', 46000),
('Sara', 'Mohamed', '103 Mohamed St, Riyadh', '678901234', 'sara.mohamed@gmail.com', 'HR', 47000),
('Mona', 'Ali', '104 Ali St, Jeddah', '789012345', 'mona.ali@gmail.com', 'HR', 48000),
('Hassan', 'Abdul', '105 Abdul St, Dammam', '890123456', 'hassan.abdul@gmail.com', 'HR', 49000),
('Zain', 'Ali', '106 Ali St, Khobar', '901234567', 'zain.ali@gmail.com', 'HR', 50000),
('Aisha', 'Nasser', '107 Nasser St, Riyadh', '012345678', 'aisha.nasser@gmail.com', 'HR', 51000),
('Rami', 'Tarek', '108 Tarek St, Jeddah', '123456780', 'rami.tarek@gmail.com', 'HR', 52000),
('Nadia', 'Hassan', '109 Hassan St, Dammam', '234567891', 'nadia.hassan@gmail.com', 'HR', 53000),
('Ibrahim', 'Khalid', '110 Khalid St, Mecca', '345678902', 'ibrahim.khalid@gmail.com', 'HR', 54000),
('Fadi', 'Saleh', '111 Saleh St, Medina', '456789013', 'fadi.saleh@gmail.com', 'HR', 55000),
('Rania', 'Khalid', '112 Khalid St, Khobar', '567890124', 'rania.khalid@gmail.com', 'HR', 56000),
('Mohammed', 'Al-Mutairi', '113 Mutairi St, Riyadh', '678901235', 'mohammed.mutairi@gmail.com', 'EMPLOYEE', 25000),
('Layla', 'Al-Khalifa', '114 Khalifa St, Jeddah', '789012346', 'layla.khalifa@gmail.com', 'EMPLOYEE', 26000),
('Yousef', 'Al-Hamadi', '115 Hamadi St, Dammam', '890123457', 'yousef.hamadi@gmail.com', 'EMPLOYEE', 27000),
('Noor', 'Al-Sabah', '116 Sabah St, Khobar', '901234568', 'noor.sabah@gmail.com', 'EMPLOYEE', 28000),
('Hadi', 'Al-Farhan', '117 Farhan St, Riyadh', '012345679', 'hadi.farhan@gmail.com', 'EMPLOYEE', 29000),
('Ranya', 'Al-Jabri', '118 Jabri St, Jeddah', '123456781', 'ranya.jabri@gmail.com', 'EMPLOYEE', 30000),
('Nabil', 'Al-Mansoori', '119 Mansoori St, Dammam', '234567892', 'nabil.mansoori@gmail.com', 'EMPLOYEE', 31000),
('Fatimah', 'Al-Hadi', '120 Hadi St, Khobar', '345678903', 'fatimah.hadi@gmail.com', 'EMPLOYEE', 32000),
('Mazen', 'Al-Dosari', '121 Dosari St, Riyadh', '456789014', 'mazen.dosari@gmail.com', 'EMPLOYEE', 33000),
('Zahra', 'Al-Saeed', '122 Saeed St, Jeddah', '567890125', 'zahra.saeed@gmail.com', 'EMPLOYEE', 34000),
('Samir', 'Al-Rahman', '123 Rahman St, Dammam', '678901236', 'samir.rahman@gmail.com', 'EMPLOYEE', 35000),
('Lina', 'Al-Jaafari', '124 Jaafari St, Khobar', '789012347', 'lina.jaafari@gmail.com', 'EMPLOYEE', 36000),
('Tariq', 'Al-Mutlaq', '125 Mutlaq St, Riyadh', '890123458', 'tariq.mutlaq@gmail.com', 'EMPLOYEE', 37000),
('Amani', 'Al-Sheikh', '126 Sheikh St, Jeddah', '901234569', 'amani.sheikh@gmail.com', 'EMPLOYEE', 38000),
('Jamal', 'Al-Muqbil', '127 Muqbil St, Dammam', '012345680', 'jamal.muqbil@gmail.com', 'EMPLOYEE', 39000),
('Hala', 'Al-Ahmad', '128 Ahmad St, Khobar', '123456782', 'hala.ahmad@gmail.com', 'EMPLOYEE', 40000),
('Yasir', 'Al-Karim', '129 Karim St, Riyadh', '234567893', 'yasir.karim@gmail.com', 'EMPLOYEE', 41000),
('Mariam', 'Al-Jarallah', '130 Jarallah St, Jeddah', '345678904', 'mariam.jarallah@gmail.com', 'EMPLOYEE', 42000),
('Rami', 'Al-Zahrani', '131 Zahrani St, Dammam', '456789015', 'rami.zahrani@gmail.com', 'EMPLOYEE', 43000),
('Heba', 'Al-Madani', '132 Madani St, Khobar', '567890126', 'heba.madani@gmail.com', 'EMPLOYEE', 44000),
('Yasir', 'Al-Muqdad', '133 Muqdad St, Riyadh', '678901237', 'yasir.muqdad@gmail.com', 'EMPLOYEE', 45000),
('Dalia', 'Al-Khalil', '134 Khalil St, Jeddah', '789012348', 'dalia.khalil@gmail.com', 'EMPLOYEE', 46000),
('Mounir', 'Al-Qassimi', '135 Qassimi St, Dammam', '890123459', 'mounir.qassimi@gmail.com', 'EMPLOYEE', 47000),
('Nadia', 'Al-Raouf', '136 Raouf St, Khobar', '901234570', 'nadia.raouf@gmail.com', 'EMPLOYEE', 48000),
('Sami', 'Al-Salim', '137 Salim St, Riyadh', '012345681', 'sami.salim@gmail.com', 'EMPLOYEE', 49000),
('Maha', 'Al-Fahad', '138 Fahad St, Jeddah', '123456783', 'maha.fahad@gmail.com', 'EMPLOYEE', 50000),
('Adel', 'Al-Ghamdi', '139 Ghamdi St, Dammam', '234567894', 'adel.ghamdi@gmail.com', 'EMPLOYEE', 51000),
('Hiba', 'Al-Ramadan', '140 Ramadan St, Khobar', '345678905', 'hiba.ramadan@gmail.com', 'EMPLOYEE', 52000),
('Fadi', 'Al-Fayez', '141 Fayez St, Riyadh', '456789016', 'fadi.fayez@gmail.com', 'EMPLOYEE', 53000),
('Amal', 'Al-Mahdi', '142 Mahdi St, Jeddah', '567890127', 'amal.mahdi@gmail.com', 'EMPLOYEE', 54000),
('Omar', 'Al-Khalid', '143 Khalid St, Dammam', '678901238', 'omar.khalid@gmail.com', 'EMPLOYEE', 55000),
('Hanan', 'Al-Mansoor', '144 Mansoor St, Khobar', '789012', 'hanan.al-mansoor@gmail.com', 'EMPLOYEE', 30000),
('Ibrahim', 'Tarek', '123 Main St, Cairo', '8753214582', 'ibrahim.tarek@gmail.com', 'EMPLOYEE', 69000),
('Fahad', 'Amir', '456 Elm St, Alexandria', '9452183625', 'fahad.amir@gmail.com', 'EMPLOYEE', 40000),
('Youssef', 'Saad', '789 Oak St, Giza', '7895241368', 'youssef.saad@gmail.com', 'EMPLOYEE', 41000),
('Khalid', 'Saleh', '987 Pine St, Luxor', '7458213569', 'khalid.saleh@gmail.com', 'EMPLOYEE', 39500),
('Hamza', 'Mahmoud', '654 Cedar St, Aswan', '6542183654', 'hamza.mahmoud@gmail.com', 'EMPLOYEE', 42000),
('Mahmoud', 'Ayman', '852 Maple St, Suez', '9521364872', 'mahmoud.ayman@gmail.com', 'EMPLOYEE', 38000),
('Rami', 'Ismail', '963 Birch St, Ismailia', '8745169234', 'rami.ismail@gmail.com', 'EMPLOYEE', 39000),
('Zaid', 'Sami', '147 Fir St, Mansoura', '8253164852', 'zaid.sami@gmail.com', 'EMPLOYEE', 40500),
('Karim', 'Rami', '258 Spruce St, Fayoum', '9482136547', 'karim.rami@gmail.com', 'EMPLOYEE', 40000),
('Amir', 'Nasser', '369 Redwood St, Damietta', '7316584951', 'amir.nasser@gmail.com', 'EMPLOYEE', 41500),
('Saad', 'Salman', '741 Aspen St, Minya', '7854321698', 'saad.salman@gmail.com', 'EMPLOYEE', 41000),
('Ali', 'Ibrahim', '852 Ash St, Sohag', '9642157832', 'ali.ibrahim@gmail.com', 'EMPLOYEE', 40000),
('Youssef', 'Hamza', '963 Chestnut St, Port Said', '7125369874', 'youssef.hamza@gmail.com', 'EMPLOYEE', 41000),
('Saleh', 'Mahmoud', '654 Walnut St, Damanhour', '8321467589', 'saleh.mahmoud@gmail.com', 'EMPLOYEE', 28000),
('Tarek', 'Rami', '321 Willow St, Beni Suef', '8741529635', 'tarek.rami@gmail.com', 'EMPLOYEE', 29000),
('Amir', 'Khalid', '789 Palm St, Asyut', '9462135874', 'amir.khalid@gmail.com', 'EMPLOYEE', 27000),
('Saad', 'Sami', '258 Bamboo St, Qena', '8423156789', 'saad.sami@gmail.com', 'EMPLOYEE', 26000),
('Ibrahim', 'Ali', '963 Mahogany St, Tanta', '9632147852', 'ibrahim.ali@gmail.com', 'EMPLOYEE', 25500),
('Fahad', 'Youssef', '741 Elmwood St, Zagazig', '8745163254', 'fahad.youssef@gmail.com', 'EMPLOYEE', 24500),
('Hassan', 'Saleh', '123 Dogwood St, Sharm El Sheikh', '7584321659', 'hassan.saleh@gmail.com', 'EMPLOYEE', 25000),
('Khalid', 'Fahad', '456 Alder St, Marsa Matruh', '8745196325', 'khalid.fahad@gmail.com', 'EMPLOYEE', 26500),
('Youssef', 'Amir', '789 Larch St, Hurghada', '9541368754', 'youssef.amir@gmail.com', 'EMPLOYEE', 27500),
('Hamza', 'Saad', '258 Sequoia St, Arish', '7895432168', 'hamza.saad@gmail.com', 'EMPLOYEE', 24000),
('Rami', 'Tarek', '963 Poplar St, Mansoura', '6542154789', 'rami.tarek@gmail.com', 'EMPLOYEE', 23500),
('Karim', 'Ismail', '852 Hawthorn St, Luxor', '8746521358', 'karim.ismail@gmail.com', 'EMPLOYEE', 24500),
('Sami', 'Mahmoud', '741 Sycamore St, Alexandria', '9874521365', 'sami.mahmoud@gmail.com', 'EMPLOYEE', 25000),
('Nasser', 'Zaid', '123 Hickory St, Aswan', '9653214589', 'nasser.zaid@gmail.com', 'EMPLOYEE', 26000),
('Ismail', 'Karim', '852 Maplewood St, Suez', '8754632159', 'ismail.karim@gmail.com', 'EMPLOYEE', 25500),
('Tarek', 'Nasser', '741 Cedarwood St, Port Said', '9452163875', 'tarek.nasser@gmail.com', 'EMPLOYEE', 28000),
('Rami', 'Hamza', '123 Redwood Dr, Ismailia', '8745623194', 'rami.hamza@gmail.com', 'EMPLOYEE', 27000),
('Ali', 'Zaid', '456 Chestnut Dr, Fayoum', '8745126395', 'ali.zaid@gmail.com', 'EMPLOYEE', 27500),
('Fahad', 'Sami', '789 Fir Dr, Giza', '9546213487', 'fahad.sami@gmail.com', 'EMPLOYEE', 26500),
('Ahmed', 'Karim', '123 Pine Dr, Tanta', '8954312657', 'ahmed.karim@gmail.com', 'EMPLOYEE', 29000),
('Mahmoud', 'Fahad', '852 Spruce Dr, Sharm El Sheikh', '7489512638', 'mahmoud.fahad@gmail.com', 'EMPLOYEE', 27000),
('Ibrahim', 'Youssef', '963 Elmwood Dr, Asyut', '8745231689', 'ibrahim.youssef@gmail.com', 'EMPLOYEE', 26000),
('Amir', 'Rami', '123 Birch Dr, Zagazig', '9541623874', 'amir.rami@gmail.com', 'EMPLOYEE', 25000),
('Karim', 'Saad', '789 Willow Dr, Damanhour', '8475129635', 'karim.saad@gmail.com', 'EMPLOYEE', 27500),
('Hamza', 'Saleh', '852 Poplar Dr, Beni Suef', '9542168374', 'hamza.saleh@gmail.com', 'EMPLOYEE', 28500),
('Zaid', 'Mahmoud', '963 Mahogany Dr, Sharm El Sheikh', '8745139265', 'zaid.mahmoud@gmail.com', 'EMPLOYEE', 28000),
('Ali', 'Amir', '258 Elm Dr, Marsa Matruh', '7894123658', 'ali.amir@gmail.com', 'EMPLOYEE', 26000),
('Tarek', 'Saleh', '456 Larch Dr, Qena', '8546231957', 'tarek.saleh@gmail.com', 'EMPLOYEE', 25500),
('Youssef', 'Hassan', '741 Fir Dr, Arish', '9845126398', 'youssef.hassan@gmail.com', 'EMPLOYEE', 24500),
('Sami', 'Amir', '963 Hickory Dr, Minya', '8546123758', 'sami.amir@gmail.com', 'EMPLOYEE', 25000),
('Rami', 'Tarek', '852 Cedar Dr, Giza', '8941237568', 'rami.tarek@gmail.com', 'EMPLOYEE', 26500),
('Karim', 'Mahmoud', '741 Redwood Dr, Hurghada', '8412637598', 'karim.mahmoud@gmail.com', 'EMPLOYEE', 27500),
('Saleh', 'Ibrahim', '963 Willow Dr, Port Said', '8541236958', 'saleh.ibrahim@gmail.com', 'EMPLOYEE', 24000),
('Tarek', 'Rami', '741 Oak Dr, Ismailia', '8546321598', 'tarek.rami2@gmail.com', 'EMPLOYEE', 23500),
('Fahad', 'Karim', '852 Birch Dr, Fayoum', '9754168235', 'fahad.karim@gmail.com', 'EMPLOYEE', 25000),
('Ali', 'Saad', '963 Maple Dr, Luxor', '8754213698', 'ali.saad@gmail.com', 'EMPLOYEE', 26500),
('Ahmed', 'Sami', '123 Cedarwood Dr, Cairo', '9756412385', 'ahmed.sami@gmail.com', 'EMPLOYEE', 26000),
('Hassan', 'Nasser', '741 Elm Dr, Alexandria', '8756341985', 'hassan.nasser@gmail.com', 'EMPLOYEE', 27000),
('Khalid', 'Zaid', '963 Mahogany Dr, Aswan', '9548123765', 'khalid.zaid@gmail.com', 'EMPLOYEE', 28500),
('Saleh', 'Mahmoud', '654 Walnut St, Damanhour', '8321467589', 'saleh.mahmoud@gmail.com', 'EMPLOYEE', 28000);

-- Use with the position it self
CREATE PROC RULES @login_id INT, @rule VARCHAR(25)
AS
  SELECT
      id,
	  firstName,
	  lastName,
	  address,
	  phone,
	  email,
      position,
	  CASE
	  WHEN @login_id = id THEN CAST(salary AS VARCHAR(25))
	  ELSE 'Not Allowed'
	  END AS salary
  FROM
      employees 
  WHERE
      position = @rule;

-- All positions
CREATE PROC EmpsWithSalary @rule VARCHAR(25)
AS
  SELECT *
  FROM employees
  WHERE position = @rule;

-- All position
CREATE PROC EmpsWithoutSalary @rule VARCHAR(25)
AS
  SELECT 
      id,
	  firstName,
	  lastName,
	  address,
	  phone,
	  email,
      position,
	  salary = 'Not Allowed'
  FROM employees
  WHERE position = @rule;



