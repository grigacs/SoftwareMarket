-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Hoszt: 127.0.0.1
-- Létrehozás ideje: 2016. Ápr 08. 11:01
-- Szerver verzió: 5.6.17
-- PHP verzió: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Adatbázis: `softwaremarket`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_admin`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- A tábla adatainak kiíratása `admin`
--

INSERT INTO `admin` (`id_admin`, `id_user`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `famous_products`
--

CREATE TABLE IF NOT EXISTS `famous_products` (
  `famous_products_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `saled_count` int(11) NOT NULL,
  PRIMARY KEY (`famous_products_id`),
  KEY `product_id` (`product_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- A tábla adatainak kiíratása `famous_products`
--

INSERT INTO `famous_products` (`famous_products_id`, `product_id`, `order_id`, `saled_count`) VALUES
(1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `order_product`
--

CREATE TABLE IF NOT EXISTS `order_product` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `total_price` float NOT NULL,
  `products_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `status` enum('ordered','saled') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- A tábla adatainak kiíratása `order_product`
--

INSERT INTO `order_product` (`order_id`, `id_user`, `order_date`, `total_price`, `products_name`, `status`) VALUES
(1, 1, '2016-04-14', 129, 'Microsoft Windows 10', 'ordered');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `product_picture` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `product_price` float NOT NULL,
  `product_version` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `product_description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=35 ;

--
-- A tábla adatainak kiíratása `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_picture`, `product_price`, `product_version`, `product_description`) VALUES
(1, 'Windows 10', '', 129, '10.0.1', 'Windows 10 is so familiar and easy to use, you’ll feel like an expert. The Start Menu is back in an expanded form, plus we’ll bring over your pinned apps and favorites so they’re ready and waiting for you.\r\n \r\nIt starts up and resumes fast, has more built-in security to help keep you safe, and is designed to work with software and hardware you already have.\r\n \r\n"This combines the strengths of Windows 8 with Windows 7."'),
(2, 'Windows 8.1', '', 110.45, '4.35', 'With the new Windows, you get the best of work and play. Windows 8.1 Pro includes everything in Windows 8.1, plus enhanced features that help you manage your devices, access one PC from another, encrypt your data, and more.'),
(3, 'Windows 7', '', 95.43, '7.63.41', 'Simplify everyday tasks: find something instantly, compare documents side-by-side, or easily back-up your complete system over a network.\r\nEnjoy a PC that works the way you want it to; supports 64-bit technologies and offers XP Mode for your business productivity applications.\r\nMake new things possible: watch Internet TV, pause, rewind, and record TV or use Touch to interact with your PC in new ways.'),
(4, 'Visual Studio 2015', '', 160.41, '5.832', 'Microsoft Visual Studio Community 2015 is a new full-featured edition that enables you to unleash the power of Visual Studio to develop cross-platform solutions.\r\n\r\nVisual Studio Community is not a trial version nor an Express-style narrowly limited product. It includes the same features as Visual Studio Professional except for the CodeLens feature. Community is the ideal Integrated Development Environment for students, and it’s completely Free!'),
(5, 'Visual Studio 2013', '', 100.61, '6.1517', 'can help you create applications that have innovative user experiences that delight your customers.'),
(6, 'SQL Server 2016', '', 78.56, '2.627', 'SQL Server 2016 Community Technology Preview 2.2 is here! It is the biggest leap forward in Microsoft’s data platform history with faster transactions and queries, deeper insights on any device, advanced analytics, new security technology, and new hybrid cloud scenarios. '),
(7, 'SQL Server 2014', '', 65.61, '1.936', 'Microsoft SQL Server 2014 builds on the mission-critical capabilities delivered in the prior release by making it easier and more cost effective to develop high-performance applications, enterprise ready Big Data assets, and Business Intelligence solutions that help customers make better decisions, faster.'),
(8, 'Access 2016', '', 135.14, '5.415', 'Access is now much more than a way to create desktop databases. It’s an easy-to-use tool for quickly creating browser-based database applications that help you run your business. Your data is automatically stored in a SQL database, so it’s more secure and scalable than ever, and you can easily share your applications with colleagues.'),
(9, 'Access 2013', '', 115.79, '2.8178', 'Access provides a simple way to build SharePoint apps. Easy-to-use tools help you get started fast and quickly share your app, improving end-users productivity from virtually anywhere.\r\n\r\nBuild and share custom apps that run on the web. No software development knowledge needed!\r\nUse a standardized app framework that makes navigating apps familiar and easy. Your app will remain professional-looking.\r\nAccess apps are accessible on SharePoint or an on-premises server via a browser.'),
(10, 'Project 2016', '', 178.31, '2.21', 'Project Professional 2016. Improve everyday collaboration.\r\n\r\nProject Professional 2016 enables you to keep your projects, resources, and teams organized and on track. Easily and efficiently plan projects, track status, and collaborate with others.\r\n\r\n\r\nWork seamlessly across tools to help everyone work together with the information they need to be successful.\r\nProject Professional 2016 provides the ability to visualize and print project reports beautifully, helping you easily and effectively share and discuss progress.\r\nThe new multiple timeline view in Project Professional 2016 helps keep you informed on all aspects of your project.\r\nQuickly focus on what matters, easily select actions to take, and seamlessly browse functions with an enhanced visual experience.'),
(11, 'Project 2013', '', 104.96, '6.817', 'Project Professional 2013 helps you easily plan projects and collaborate with others from virtually anywhere.'),
(12, 'Visio 2013', '', 98.76, '1.787', 'Visio 2013 provides new features designed to help you create diagrams more intuitively—including new and updated shapes and stencils, improved effects and themes, and a coauthoring feature that makes teamwork easier.'),
(13, 'Visio 2016', '', 110.48, '2.14', 'Simplify and communicate complex information with data linked diagrams.\r\n\r\nVisio Professional 2016 makes it easier than ever to create and share professional, versatile diagrams that simplify and communicate complex information.\r\n\r\n\r\nWith Visio, you can use the shapes in your diagram to show real-time data with real-world visual. Vibrant icons, symbols, colors, and bar graphs can make your data instantly understandable.\r\nGetting Started Experience provides a select set of pre-crafted starter diagrams and contextual tips and tricks to help the users to create, edit and complete their diagrams quickly'),
(14, 'InfoPath 2013', '', 74.72, '13.728', 'Quickly create forms to support processes using the familiar Microsoft Office tools, such as fonts, bullets and numbering, table design, and clip art. The familiar tools and environment help minimize training time and speed forms creation.'),
(15, 'Lync 2013', '', 65.98, '4.820', 'Microsoft Lync 2013 is an enterprise-ready unified communications platform. Lync connects hundreds of millions of people everywhere, on Windows 8 and other devices, as part of their everyday productivity experience.'),
(16, 'MapPoint Euro 2013', '', 194.56, '2.25', 'MapPoint 2013 European Maps gives you the power to visualize sales, competitor and customer data to make better business decisions. Create information-rich maps with your data to show important relationships, identify business trends, and illustrate opportunities. When on the road, get trip routing and turn-by-turn directions to easily plan better trips.\r\n\r\nCreate information-rich maps with your data to show important relationships and identify business trends\r\nCreate sales territories and share performance maps to clearly visualize, analyze, and communicate performance\r\nInsert maps into Word documents and PowerPoint presentations to illustrate everything from sales performance and customer locations to new business opportunities'),
(17, 'MapPoint North America 2013', '', 175.31, '3.46', ' MapPoint ® 2013 gives you the power to visualize business data and communicate insights with instant impact. Before you hit the road, plug in your stops and MapPoint plots the most efficient course with turn-by-turn driving directions.'),
(18, 'Windows Server 2016', '', 136.57, '2.52', 'At the heart of the Microsoft Cloud Platform, Windows Server brings Microsoft’s experience delivering global-scale cloud services into your infrastructure.'),
(19, 'Windows Server 2012', '', 120.51, '1.61', 'Windows Server 2012 helps you flexibly build, deploy faster and scale web applications on-premises and in the cloud, using your development skills and knowledge.'),
(20, 'Songsmith', '', 74.31, '3.16', 'Whether you’re a musical novice looking to send a jingle to a friend or an aspiring songwriter looking to give it a first try, Songsmith helps you create music. Create songs using just your voice, and choose musical accompaniments to match whatever you sing.'),
(21, 'Visual FoxPro 9', '', 58.59, '2.72', 'With its local cursor engine, tight coupling between language and data, and powerful features, Visual FoxPro 9.0 is a great tool for building database solutions of all sizes.'),
(22, 'MS-DOS 6.22', '', 45.67, '6.22', 'Microsoft MS-DOS operating system 6.22'),
(23, 'Windows Web Server 2008', '', 103.67, '2.56', 'Windows Server 2008 helps IT professionals to increase the flexibility and reliability of their server infrastructure while offering developers a more robust web and applications platform for building connected applications and services.'),
(24, '.NET Framework 4.5', '', 130.93, '4.5', 'The .NET Framework 4.5 is a highly compatible, in-place update to the .NET Framework 4.'),
(25, 'Microsoft Azure Mobile SDK', '', 96.35, '4.78', 'Accelerate your mobile app development. Add structured storage, user authentication and push notifications to your Android, iOS, HTML, Windows Store, or Windows Phone 8 app in minutes.'),
(26, 'Expression Studio 4', '', 127.64, '1.86', 'Expression Blend\r\nExpression Blend, Visual Studio, Silverlight and .NET provide a seamless design and development workflow. Ideas evolve from your initial prototyping with SketchFlow, a feature included with Expression Studio Ultimate, to the completed project quickly and effectively, enabling you to create compelling applications for your customers.\r\nExpression Blend 4 Service Pack now available.'),
(27, 'OneNote 2013', '', 85.82, '2.23', 'OneNote is a digital notebook for creating and storing all your notes. Your notes are automatically saved and searchable so you have them when you need them. And when you’re on the go, they travel with you on your favorite devices or nearly any browser.'),
(28, 'System Center 2012', '', 100.56, '4.62', 'System Center 2012 helps you manage your IT environments across datacenters, the cloud, client computers, and devices.'),
(29, 'SharePoint Server 2010', '', 88.52, '1.71', 'Microsoft SharePoint 2010 enables organizations to connect and empower people through an integrated set of rich features. SharePoint 2010 facilitates business collaboration in its broadest sense and helps colleagues, partners, and customers to work together in new and effective ways.'),
(30, 'Exchange Server 2013', '', 105.78, '3.67', 'Microsoft Exchange Server 2013 enables you to maintain control, increase user productivity, and keep your organization safe.'),
(31, 'PowerPivot for Excel 2010', '', 43.16, '1.61', 'PowerPivot for Excel 2010 is a data analysis tool that delivers unmatched computational power directly within the software users already know and love—Microsoft Excel.'),
(32, 'AutoCollage 2008', '', 34.86, '7.41', 'Photo collages celebrate important events and themes in our lives. Pick a folder, press a button, and in a few minutes AutoCollage presents you with a unique memento to print or email to your family and friends.'),
(33, 'Solver Foundation 3.1', '', 0, '3.1', 'Microsoft Solver Foundation is a .NET solution for mathematical optimization and modeling. Solver Foundation makes it easier to build and solve real optimization models.'),
(34, 'Windows DNA XML', '', 61.15, '1.57', '-');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product_category`
--

CREATE TABLE IF NOT EXISTS `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `category_name` enum('Operating Systems','Developer Tools','Applications','Servers') COLLATE utf8_unicode_ci NOT NULL,
  `category_description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`category_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=40 ;

--
-- A tábla adatainak kiíratása `product_category`
--

INSERT INTO `product_category` (`category_id`, `product_id`, `category_name`, `category_description`) VALUES
(1, 1, 'Operating Systems', 'Microsoft Operation System'),
(2, 2, 'Operating Systems', 'Microsoft Operating System'),
(3, 3, 'Operating Systems', 'Microsoft Operating System'),
(4, 4, 'Developer Tools', 'Microsoft Developer Tools'),
(5, 5, 'Developer Tools', 'Microsoft Developer Tools'),
(6, 6, 'Developer Tools', 'Microsoft Developer Tools'),
(7, 7, 'Developer Tools', 'Microsoft Developer Tools'),
(8, 8, 'Applications', 'Microsoft Applications'),
(9, 9, 'Applications', 'Microsoft Applications'),
(10, 10, 'Applications', 'Microsoft Applications'),
(11, 11, 'Applications', 'Microsoft Applications'),
(12, 12, 'Applications', 'Microsoft Applications'),
(13, 13, 'Applications', 'Microsoft Applications'),
(14, 14, 'Applications', 'Microsoft Applications'),
(15, 15, 'Applications', 'Microsoft Applications'),
(16, 16, 'Applications', 'Microsoft Applications'),
(17, 17, 'Applications', 'Microsoft Applications\r\n'),
(18, 18, 'Servers', 'Microsoft Server'),
(19, 19, 'Servers', 'Microsoft Server'),
(20, 6, 'Servers', 'Microsoft Server'),
(21, 7, 'Servers', 'Microsoft Server'),
(22, 20, 'Developer Tools', 'Microsoft Developer Tools'),
(23, 21, 'Developer Tools', 'Microsoft Developer Tools'),
(24, 24, 'Developer Tools', 'Microsoft Developer Tools'),
(25, 26, 'Developer Tools', 'Microsoft Developer Tools'),
(26, 28, 'Developer Tools', 'Microsoft Developer Tools'),
(27, 27, 'Applications', 'Microsoft Application'),
(28, 22, 'Operating Systems', 'Microsoft Operating System'),
(29, 23, 'Operating Systems', 'Microsoft Operating System'),
(30, 25, 'Developer Tools', 'Microsoft Developer Tools'),
(31, 28, 'Servers', 'Microsoft Server'),
(32, 29, 'Servers', 'Microsoft Server'),
(33, 30, 'Servers', 'Microsoft Server'),
(34, 31, 'Applications', 'Microsoft Application'),
(35, 32, 'Applications', 'Microsoft Application'),
(36, 4, 'Applications', 'Microsoft Application'),
(37, 5, 'Applications', 'Microsoft Application'),
(38, 33, 'Applications', ''),
(39, 34, 'Applications', '');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `products`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `birth_date` date NOT NULL,
  `sex` enum('man','woman') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- A tábla adatainak kiíratása `products`
--

INSERT INTO `users` (`id_user`, `first_name`, `last_name`, `username`, `password`, `birth_date`, `sex`) VALUES
(1, 'Dér', 'Gergely', 'grigacs', 'grigacs11', '1991-09-25', 'man');

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `famous_products`
--
ALTER TABLE `famous_products`
  ADD CONSTRAINT `famous_products_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order_product` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `famous_products_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `order_product`
--
ALTER TABLE `order_product`
  ADD CONSTRAINT `order_product_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `product_category`
--
ALTER TABLE `product_category`
  ADD CONSTRAINT `product_category_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
