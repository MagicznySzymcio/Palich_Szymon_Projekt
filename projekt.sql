-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 07 Gru 2020, 17:42
-- Wersja serwera: 10.4.14-MariaDB
-- Wersja PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projekt`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `id_klienta` int(11) NOT NULL,
  `nazwisko` varchar(40) NOT NULL,
  `imie` varchar(20) NOT NULL,
  `nazwa_firmy` varchar(20) DEFAULT NULL,
  `miasto` varchar(20) NOT NULL,
  `ulica_nr_domu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`id_klienta`, `nazwisko`, `imie`, `nazwa_firmy`, `miasto`, `ulica_nr_domu`) VALUES
(1, 'Apoloniusz Curuś Bachleda Farrell', 'Tomisław', NULL, 'Gubałówka', 'Okolice'),
(2, 'Makowska', 'Ewelina', NULL, 'Warszawa', 'Jana Pawla 5'),
(3, 'Zalewska', 'Izyda', 'Izydex', 'Telatyn', '2'),
(4, 'Czarnecka', 'Balbina', NULL, 'Rzeszów', 'Cicha 2');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `id_pracownika` int(11) NOT NULL,
  `id_stanowiska` int(11) NOT NULL,
  `nazwisko` varchar(20) NOT NULL,
  `imie` varchar(20) NOT NULL,
  `data_zatrudnienia` date NOT NULL,
  `data_zwolnienia` date DEFAULT NULL,
  `wynagrodzenie` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`id_pracownika`, `id_stanowiska`, `nazwisko`, `imie`, `data_zatrudnienia`, `data_zwolnienia`, `wynagrodzenie`) VALUES
(1, 1, 'Cieślak', 'Marian', '2020-12-01', NULL, '2345.00'),
(2, 2, 'Kaźmierczak', 'Eugeniusz', '2020-12-03', NULL, '1122.33'),
(3, 3, 'Plizga', 'Patryk', '2020-12-06', '2020-12-07', '2.00');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `stanowisko`
--

CREATE TABLE `stanowisko` (
  `id_stanowiska` int(11) NOT NULL,
  `nazwa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

--
-- Zrzut danych tabeli `stanowisko`
--

INSERT INTO `stanowisko` (`id_stanowiska`, `nazwa`) VALUES
(1, 'Majster'),
(2, 'Pomocnik'),
(3, 'Asystent Pomocnika');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `usluga`
--

CREATE TABLE `usluga` (
  `id_uslugi` int(11) NOT NULL,
  `nazwa` varchar(20) NOT NULL,
  `cena` decimal(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

--
-- Zrzut danych tabeli `usluga`
--

INSERT INTO `usluga` (`id_uslugi`, `nazwa`, `cena`) VALUES
(1, 'Wymiana dysku', '100.00'),
(2, 'Usunięcie Windowsa', '10.00'),
(3, 'Instalacja Linuxa', '2.00'),
(4, 'Testowanie projektu', '444.44');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienie`
--

CREATE TABLE `zamowienie` (
  `id_zamowienia` int(11) NOT NULL,
  `id_klienta` int(11) NOT NULL,
  `id_pracownika` int(11) NOT NULL,
  `id_usługi` int(11) NOT NULL,
  `data_zamowienia` date NOT NULL,
  `data_realizacji` date NOT NULL,
  `zrealizowano` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;

--
-- Zrzut danych tabeli `zamowienie`
--

INSERT INTO `zamowienie` (`id_zamowienia`, `id_klienta`, `id_pracownika`, `id_usługi`, `data_zamowienia`, `data_realizacji`, `zrealizowano`) VALUES
(1, 1, 1, 4, '2020-12-03', '2020-12-05', 1),
(2, 2, 2, 1, '2020-12-21', '2020-12-24', 0);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`id_klienta`),
  ADD KEY `id_klienta` (`id_klienta`);

--
-- Indeksy dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`id_pracownika`),
  ADD KEY `id_stanowiska` (`id_stanowiska`);

--
-- Indeksy dla tabeli `stanowisko`
--
ALTER TABLE `stanowisko`
  ADD PRIMARY KEY (`id_stanowiska`);

--
-- Indeksy dla tabeli `usluga`
--
ALTER TABLE `usluga`
  ADD PRIMARY KEY (`id_uslugi`);

--
-- Indeksy dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD PRIMARY KEY (`id_zamowienia`),
  ADD KEY `id_pracownika` (`id_pracownika`),
  ADD KEY `id_produktu` (`id_usługi`),
  ADD KEY `id_klienta` (`id_klienta`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `klient`
--
ALTER TABLE `klient`
  MODIFY `id_klienta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  MODIFY `id_pracownika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `stanowisko`
--
ALTER TABLE `stanowisko`
  MODIFY `id_stanowiska` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `usluga`
--
ALTER TABLE `usluga`
  MODIFY `id_uslugi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  MODIFY `id_zamowienia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD CONSTRAINT `pracownik_fk1` FOREIGN KEY (`id_stanowiska`) REFERENCES `stanowisko` (`id_stanowiska`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD CONSTRAINT `zamowienie_fk1` FOREIGN KEY (`id_klienta`) REFERENCES `klient` (`id_klienta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zamowienie_fk2` FOREIGN KEY (`id_pracownika`) REFERENCES `pracownik` (`id_pracownika`) ON UPDATE CASCADE,
  ADD CONSTRAINT `zamowienie_fk3` FOREIGN KEY (`id_usługi`) REFERENCES `usluga` (`id_uslugi`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
