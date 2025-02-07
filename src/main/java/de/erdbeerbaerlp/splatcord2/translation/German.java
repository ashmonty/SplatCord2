package de.erdbeerbaerlp.splatcord2.translation;

import de.erdbeerbaerlp.splatcord2.storage.Config;

public class German extends EnglishBase {
    {
        salmonStage = "Arenen:";
        weapons = "Waffen:";
        stagesTitle = "Aktuelle Arenen";
        futureStagesTitle = "Zukünftige Arenen";
        footer_ends = "Endet";
        footer_starts = "Startet";
        footer_closed = "Geschlossen";
        unknownCommand = "Unbekannter Befehl";
        noAdminPerms = "Du benötigst Administrative Berechtigungen (Server verwalten) um diesen Befehl auszuführen!";
        stageFeedMsg = "Aktuelle Arenen werden nun regelmäßig in diesen Kanal gesendet";
        salmonFeedMsg = "Aktuelle Salmon Runs werden nun regelmäßig in diesen Kanal gesendet";
        languageSetMessage = "Die Sprache dieses Servers ist nun auf Deutsch eingestellt";
        unknownLanguage = "Du hast keine valide Sprache angegeben. Vorhandene Sprachen: Deutsch (de), Englisch (en), und Italienisch (it)";
        deleteSuccessful = "Erfolgreich gelöscht!";
        noWritePerms = "Dieser Bot hat keine Berechtigung, Nachrichten in diesen Kanal zu senden";
        skill = "Effekt:";
        skillSlots = "Effekt-Slots:";
        price = "Preis:";
        splatNetShop = "TentaWorld";
        splatnetCooldown = "Der TentaWorld-Befehl ist gerade im Cooldown. Versuche es in ein paar Minuten erneut.";
        legacyCommand = "Du versuchst, einen veralteten Befehl zu verwenden. Dies ist nicht mehr möglich!\n" +
                "Benutze stattdessen die Slash-Befehle\n" +
                "Falls du Server-Admin bist und noch keine Slash-Befehle nutzen kannst, besuche <https://discord.com/api/oauth2/authorize?client_id=822228767165644872&scope=applications.commands> und wähle diesen Server aus. Danach kannst du die Slash-Befehle mit " + Config.instance().discord.prefix + "fixslashcommands aktivieren";
        cmdFixSlashCommands = "Slash-Befehle sollten nur wieder funktionieren!\n" +
                "Falls dies nicht der fall ist, kontaktiere den Bot-Entwickler";
        cmdSetlangDesc = "Ändert die Botsprache für diesen Server";
        cmdInviteDesc = "Sendet den Einladungslink des Bots";
        cmdSetsalmonDesc = "Markiert einen Kanal für SalmonRun Benachrichtigungen";
        cmdDelsalmonDesc = "Löscht den gesetzten SalmonRun-Kanal";
        cmdSetstageDesc = "Markiert einen Kanal für Arena benachrichtigungen";
        cmdDelstageDesc = "Löscht den gesetzten Arena-Kanal";
        cmdCodeDesc = "Generiert einen zufälligen Privatkampf-code";
        cmdCodeArgDesc = "Code vor anderen verstecken? (Standart: wird angezeigt)";
        cmdRotationDesc = "Sendet die aktuell aktiven Arenen und die nächsten Rotationen";
        cmdSupportDesc = "Sendet den Einladungslink zum Discord vom Bot";
        cmdRandomAmountDesc = "Anzahl zum Generieren (standart=1, maximum=10)";
        cmdRandomWeaponDesc = "Generiere zufällige Waffen";
        cmdRandomStageDesc = "Generiere zufällige Arenen";
        cmdSalmonDesc = "Zeigt aktuellen und nächsten Salmon Run";
        cmdSplatnetDesc = "Sendet die aktuelle Ausrüstung von TentaWorld";
        cmdStatusDB = "Datenbank";
        cmdStatusDesc = "Zeigt Bostatus und Statistiken";
        cmdStatusStats = "Statistiken";
        cmdStatusStatsServers = "Server: ";
        cmdStatusStatsUptime = "Uptime: ";
        cmdStatusStatsDbUptime = "Datenbank-Uptime: ";
        cmdProfile1Desc = "Zeigt oder bearbeitet den Splatoon 1 Profil";
        cmdProfile2Desc = "Zeigt oder bearbeitet den Splatoon 2 Profil";
        cmdProfile3Desc = "Zeigt oder bearbeitet den Splatoon 3 Profil";
        cmdProfilennidErr = "Um das Profil Feature zu verwenden, musst du erst deine Nintendo Network ID oder Pretendo Network ID festlegen!";
        cmdProfilefcErr = "Um das Profil Feature zu verwenden, musst du erst deinen Switch Freundes Code!";
        cmdProfileRankFormatNotValid = "Das Rang-Format ist fehlerhaft !";
        cmdProfileS1RankSet = "Dein Splatoon 1 Rang wurde auf %rank% gesetzt";
        cmdProfileS2RankSet = "Dein %mode% rang wurde auf %rank% gesetzt";
        cmdProfileS2SalmonSet = "Dein Salmon Run Titel ist nun %title%";
        cmdProfileSwitchFCDesc = "Dein Switch Freundes Codes";
        cmdProfileNNIDDesc = "Deine Nintendo Network ID";
        cmdProfilePNIDDesc = "Deine Pretendo Network ID";
        cmdProfileLevelDesc = "Dein in-game Level";
        cmdProfileNameDesc = "Dein in-game Name";
        cmdProfileRankDesc = "Dein Splatoon Rang (Beispiele: C-, A, S)";
        cmdProfileRank2Desc = "Dein Splatoon 2 %mode% Rang (Beispiele: C-, B, S+4, X 2000)";
        salmonRunTitleUnset = "Praktikant";
        salmonRunTitleApprentice = "Praktikant";
        salmonRunTitlePartTimer = "Lehrling";
        salmonRunTitleGoGetter = "Mitarbeiter des Monats";
        salmonRunTitleOverachiever = "Führungskraft";
        salmonRunTitleProfreshional = "Boss";
        cmdProfileRank = "Rang";
        cmdProfileLevel = "Level";
        cmdProfileSRTitleDesc = "Dein Salmon Run Titel";
        cmdProfileSRTitle = "Salmon Run Titel";
        cmdProfileNameErr = "Name zu lang! Es sind nur max. 10 Zeichen erlaubt!";
        cmdProfileLevel1Set = "Splatoon 1 level gesetzt auf ";
        cmdProfileLevel2Set = "Splatoon 2 level gesetzt auf ";
        cmdProfileNameSet = "In-Game Name gesetzt auf ";
        cmdProfileMissingNID = "Du hast noch keine Nintendo Network ID oder eine Pretendo Network ID festgelegt";
        cmdProfileMissingFC = "Du hast noch keinen Switch Freundescode festgelegt.";
        cmdProfileFCSet = "Switch Freundescode gesetzt auf ";
    }
}
