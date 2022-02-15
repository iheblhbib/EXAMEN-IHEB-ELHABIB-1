-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 15 fév. 2022 à 21:17
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `examen-iheb-elhabib`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `created`, `pays`, `ville`, `zipcode`) VALUES
(1, '2022-02-15 21:17:08', 'Tunisie', 'Le Bardo', '2000');

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` bigint(20) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longtitude` double DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `adresse_id` bigint(20) DEFAULT NULL,
  `banque_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id`, `latitude`, `longtitude`, `tel`, `adresse_id`, `banque_id`) VALUES
(1, 18, 31, 81555555, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `siteweb` varchar(255) DEFAULT NULL,
  `slogon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `banque`
--

INSERT INTO `banque` (`id`, `email`, `logo`, `nom`, `reference`, `siteweb`, `slogon`) VALUES
(1, 'contact@banquezitouna.com', NULL, 'Zitouna Banque', 'ZITN', 'https://www.banquezitouna.com/', 'ZTN');

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE `carte` (
  `id` bigint(20) NOT NULL,
  `cotisation` double DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `plafond_global` double DEFAULT NULL,
  `plafond_retrait` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `carte`
--

INSERT INTO `carte` (`id`, `cotisation`, `created`, `num`, `plafond_global`, `plafond_retrait`) VALUES
(1, 5, '2022-02-15 21:17:08', '1234 5678 1234 5678', 10000, 1000),
(2, 5, '2022-02-15 21:17:08', '9999 5678 1234 5678', 10000, 1000);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `adresse_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `created`, `email`, `nom`, `prenom`, `tel`, `adresse_id`) VALUES
(1, '2022-02-15 21:17:08', 'elhabib.iheb@suptech.tn', 'elhabib', 'iheb', 95198006, 1);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` bigint(20) NOT NULL,
  `cout` double DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `iban` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `rib` int(11) DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `agence_id` bigint(20) DEFAULT NULL,
  `carte_id` bigint(20) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `offre_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `cout`, `created`, `etat`, `iban`, `montant`, `rib`, `taux`, `type`, `agence_id`, `carte_id`, `client_id`, `offre_id`) VALUES
(1, 0.78, '2022-02-15 21:17:08', 'OUVERT', 'ZTN00001', 4010.1600000000003, 1, 5, 'COURANT', 1, 1, 1, 1),
(2, 0.78, '2022-02-15 21:17:08', 'OUVERT', 'ZTN00002', 1922.5, 2, 5, 'COURANT', 1, 2, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `compte_credits`
--

CREATE TABLE `compte_credits` (
  `compte_id` bigint(20) NOT NULL,
  `credits_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `compte_transaction`
--

CREATE TABLE `compte_transaction` (
  `compte_id` bigint(20) NOT NULL,
  `transaction_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `credit`
--

CREATE TABLE `credit` (
  `id` bigint(20) NOT NULL,
  `agios` double DEFAULT NULL,
  `depot` datetime DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `interrogation` datetime DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `compte_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `frais`
--

CREATE TABLE `frais` (
  `id` bigint(20) NOT NULL,
  `cion` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `frais`
--

INSERT INTO `frais` (`id`, `cion`) VALUES
(1, 1430);

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `frais` double DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `banque_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `created`, `frais`, `libelle`, `banque_id`) VALUES
(1, '2022-02-15 21:17:08', 72.5, 'Starter', 1);

-- --------------------------------------------------------

--
-- Structure de la table `offre_clients`
--

CREATE TABLE `offre_clients` (
  `offre_id` bigint(20) NOT NULL,
  `clients_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `newmontant` double DEFAULT NULL,
  `oldmontant` double DEFAULT NULL,
  `carte_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`id`, `created`, `libelle`, `montant`, `newmontant`, `oldmontant`, `carte_id`) VALUES
(1, '2022-02-15 21:17:09', 'First extrait', 230, 4691.72, 4922.5, 1),
(2, '2022-02-15 21:17:09', 'First extrait', 80, 4610.9400000000005, 4691.72, 1),
(3, '2022-02-15 21:17:09', 'First extrait', 600, 4010.1600000000003, 4610.9400000000005, 1);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, 'Super Admin', 'Admin'),
(2, 'Client', 'Client');

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `distinataire` int(11) DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `sens` varchar(255) DEFAULT NULL,
  `source` int(11) DEFAULT NULL,
  `compte_id` bigint(20) DEFAULT NULL,
  `frais_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id`, `created`, `distinataire`, `montant`, `sens`, `source`, `compte_id`, `frais_id`) VALUES
(1, '2022-02-15 21:17:09', 1, 750, 'INTERNE', 2, NULL, 1),
(2, '2022-02-15 21:17:09', 2, 1000, 'INTERNE', 1, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `role_id`) VALUES
(1, '123', 'Admin', NULL),
(2, '123', 'Client', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp92fb4t8wfnxo6wwuf59vrogi` (`adresse_id`),
  ADD KEY `FKtcvw1tlheqwy9evilip6piiop` (`banque_id`);

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK29btfh0bmn7ww7p2ksjlm1p` (`adresse_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjpt17mqmkajvmf57ui6erwf92` (`agence_id`),
  ADD KEY `FKf3drsy9vrwuws0si05cmly0tw` (`carte_id`),
  ADD KEY `FK5qv5tcfmwu2mli0brm27y13gl` (`client_id`),
  ADD KEY `FKqi536518stcqjk7e4gqg7wafl` (`offre_id`);

--
-- Index pour la table `compte_credits`
--
ALTER TABLE `compte_credits`
  ADD UNIQUE KEY `UK_capf6y0uo6opfqxa86qhp4xij` (`credits_id`),
  ADD KEY `FK5lxhqmn8ukrc4onk67pyjhxq3` (`compte_id`);

--
-- Index pour la table `compte_transaction`
--
ALTER TABLE `compte_transaction`
  ADD UNIQUE KEY `UK_4hoeyp5o3lk0g24o1bhpxv72h` (`transaction_id`),
  ADD KEY `FK2154uqwlrtu3pqstjwkj4inqk` (`compte_id`);

--
-- Index pour la table `credit`
--
ALTER TABLE `credit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk89k27iv1aeyte5hsctgx76ab` (`compte_id`);

--
-- Index pour la table `frais`
--
ALTER TABLE `frais`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhtmvt5bmp5f4ji4noqcqu0n1t` (`banque_id`);

--
-- Index pour la table `offre_clients`
--
ALTER TABLE `offre_clients`
  ADD UNIQUE KEY `UK_qh2jkdv6xi8ec5phb9kai669b` (`clients_id`),
  ADD KEY `FK6max23kaf5jq2u8cwbslsdtve` (`offre_id`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtrt3b12r225vl3vcgauxcqma8` (`carte_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsb56lsmpjfoulaex18sggti8g` (`compte_id`),
  ADD KEY `FKbv86wsb07hn71grvff4crphp4` (`frais_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `banque`
--
ALTER TABLE `banque`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `carte`
--
ALTER TABLE `carte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `credit`
--
ALTER TABLE `credit`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `frais`
--
ALTER TABLE `frais`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `agence`
--
ALTER TABLE `agence`
  ADD CONSTRAINT `FKp92fb4t8wfnxo6wwuf59vrogi` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `FKtcvw1tlheqwy9evilip6piiop` FOREIGN KEY (`banque_id`) REFERENCES `banque` (`id`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK29btfh0bmn7ww7p2ksjlm1p` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK5qv5tcfmwu2mli0brm27y13gl` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKf3drsy9vrwuws0si05cmly0tw` FOREIGN KEY (`carte_id`) REFERENCES `carte` (`id`),
  ADD CONSTRAINT `FKjpt17mqmkajvmf57ui6erwf92` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`),
  ADD CONSTRAINT `FKqi536518stcqjk7e4gqg7wafl` FOREIGN KEY (`offre_id`) REFERENCES `offre` (`id`);

--
-- Contraintes pour la table `compte_credits`
--
ALTER TABLE `compte_credits`
  ADD CONSTRAINT `FK1rhmomdrunxp3uyhqssgcmnkh` FOREIGN KEY (`credits_id`) REFERENCES `credit` (`id`),
  ADD CONSTRAINT `FK5lxhqmn8ukrc4onk67pyjhxq3` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`id`);

--
-- Contraintes pour la table `compte_transaction`
--
ALTER TABLE `compte_transaction`
  ADD CONSTRAINT `FK2154uqwlrtu3pqstjwkj4inqk` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`id`),
  ADD CONSTRAINT `FKhgf97yry8q891kh9auqid1y22` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`);

--
-- Contraintes pour la table `credit`
--
ALTER TABLE `credit`
  ADD CONSTRAINT `FKk89k27iv1aeyte5hsctgx76ab` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`id`);

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `FKhtmvt5bmp5f4ji4noqcqu0n1t` FOREIGN KEY (`banque_id`) REFERENCES `banque` (`id`);

--
-- Contraintes pour la table `offre_clients`
--
ALTER TABLE `offre_clients`
  ADD CONSTRAINT `FK2y45phvh6ok1067eixnm5xlav` FOREIGN KEY (`clients_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FK6max23kaf5jq2u8cwbslsdtve` FOREIGN KEY (`offre_id`) REFERENCES `offre` (`id`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FKtrt3b12r225vl3vcgauxcqma8` FOREIGN KEY (`carte_id`) REFERENCES `carte` (`id`);

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FKbv86wsb07hn71grvff4crphp4` FOREIGN KEY (`frais_id`) REFERENCES `frais` (`id`),
  ADD CONSTRAINT `FKsb56lsmpjfoulaex18sggti8g` FOREIGN KEY (`compte_id`) REFERENCES `compte` (`id`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
