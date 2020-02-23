-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  sam. 22 fév. 2020 à 11:52
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cloud_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `besoin`
--

CREATE TABLE `besoin` (
  `id_besoin` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `id_demande` int(11) NOT NULL,
  `date_demande` date DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL,
  `id_service` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `element_besoin_demande`
--

CREATE TABLE `element_besoin_demande` (
  `id_demande` int(11) NOT NULL,
  `id_el_besoin` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `element_de_besoin`
--

CREATE TABLE `element_de_besoin` (
  `id_el_besoin` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `valeur` varchar(255) DEFAULT NULL,
  `id_besoin` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `faire_demande`
--

CREATE TABLE `faire_demande` (
  `id_demande` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id_message` int(11) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`id_message`, `contenu`, `id_personne`) VALUES
(1, 'sdsdfsd', 1),
(2, 'sdsdfsd', 1),
(3, 'sdsdfsd', 1);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_personne` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_message` int(11) DEFAULT NULL,
  `nom_per` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `plainte`
--

CREATE TABLE `plainte` (
  `id_plainte` int(11) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `id_service` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `RELIER`
--

CREATE TABLE `RELIER` (
  `ID_SERVICE` int(11) NOT NULL,
  `ID_BESOIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `relier`
--

CREATE TABLE `relier` (
  `id_besoin` int(11) NOT NULL,
  `id_service` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `id_reponse` int(11) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `id_message` int(11) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE `service` (
  `id_service` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_besoin` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `besoin`
--
ALTER TABLE `besoin`
  ADD PRIMARY KEY (`id_besoin`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`id_demande`),
  ADD KEY `FK6o56fxi636g1y2y4xx8ct8v9m` (`id_personne`),
  ADD KEY `FKg85e3v0itve2xhbk52hua7vjp` (`id_service`);

--
-- Index pour la table `element_besoin_demande`
--
ALTER TABLE `element_besoin_demande`
  ADD KEY `FKo1qop8s9cugh6qbau9axnwer7` (`id_el_besoin`),
  ADD KEY `FKj4pltwl9hok7omdgtyntn7910` (`id_demande`);

--
-- Index pour la table `element_de_besoin`
--
ALTER TABLE `element_de_besoin`
  ADD PRIMARY KEY (`id_el_besoin`),
  ADD KEY `FKflumsb8847fm47uqd4psm7cug` (`id_besoin`);

--
-- Index pour la table `faire_demande`
--
ALTER TABLE `faire_demande`
  ADD KEY `FKn0werwqrfucq710j1ro8g8vi` (`id_personne`),
  ADD KEY `FKipfxjhg9kosloh48ljwynmler` (`id_demande`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_message`),
  ADD KEY `FK1g2c1ut28kib1e36loohm40ba` (`id_personne`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- Index pour la table `plainte`
--
ALTER TABLE `plainte`
  ADD PRIMARY KEY (`id_plainte`),
  ADD KEY `FKew9vieia68093bawe9ny84ldl` (`id_service`);

--
-- Index pour la table `RELIER`
--
ALTER TABLE `RELIER`
  ADD PRIMARY KEY (`ID_SERVICE`,`ID_BESOIN`);

--
-- Index pour la table `relier`
--
ALTER TABLE `relier`
  ADD PRIMARY KEY (`id_besoin`,`id_service`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`id_reponse`),
  ADD KEY `FK5r9v5mpv4yf1h43pn6g4wli31` (`id_message`),
  ADD KEY `FKm1yqy2x8quxj2a7wkvjd80lgn` (`id_personne`);

--
-- Index pour la table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id_service`),
  ADD KEY `FK1glcabx81t6p9m4a5y2cylsfq` (`id_besoin`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `besoin`
--
ALTER TABLE `besoin`
  MODIFY `id_besoin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `id_demande` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `element_de_besoin`
--
ALTER TABLE `element_de_besoin`
  MODIFY `id_el_besoin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id_message` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id_personne` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `plainte`
--
ALTER TABLE `plainte`
  MODIFY `id_plainte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `id_reponse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `service`
--
ALTER TABLE `service`
  MODIFY `id_service` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
