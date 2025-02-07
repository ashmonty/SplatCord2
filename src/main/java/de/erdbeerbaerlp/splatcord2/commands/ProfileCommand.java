package de.erdbeerbaerlp.splatcord2.commands;

import de.erdbeerbaerlp.splatcord2.Main;
import de.erdbeerbaerlp.splatcord2.storage.SplatProfile;
import de.erdbeerbaerlp.splatcord2.storage.json.splatoon1.Splat1Profile;
import de.erdbeerbaerlp.splatcord2.storage.json.splatoon2.Splat2Profile;
import de.erdbeerbaerlp.splatcord2.storage.json.splatoon2.translations.Locale;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

public class ProfileCommand extends BaseCommand {
    public ProfileCommand(Locale l) {
        super("profile", l.botLocale.cmdProfileDesc);
        final SubcommandData splat1 = new SubcommandData("splat1", l.botLocale.cmdProfile1Desc);
        final SubcommandData splat2 = new SubcommandData("splat2", l.botLocale.cmdProfile2Desc);
        //SubcommandData splat3 = new SubcommandData("splat3",l.botLocale.cmdProfile3Desc);


        //Common
        final OptionData wiiuNNID = new OptionData(OptionType.STRING, "nintendo-id", l.botLocale.cmdProfileNNIDDesc, false);
        final OptionData wiiuPNID = new OptionData(OptionType.STRING, "pretendo-id", l.botLocale.cmdProfilePNIDDesc, false);
        final OptionData switchfc = new OptionData(OptionType.STRING, "switch-fc", l.botLocale.cmdProfileSwitchFCDesc, false);
        final OptionData splatlevel = new OptionData(OptionType.INTEGER, "level", l.botLocale.cmdProfileLevelDesc, false);
        final OptionData splatname = new OptionData(OptionType.STRING, "name", l.botLocale.cmdProfileNameDesc, false);

        //Splatoon 1 only
        final OptionData rank = new OptionData(OptionType.STRING, "rank", l.botLocale.cmdProfileRankDesc, false);


        //Splatoon 2 only
        final OptionData rainmaker = new OptionData(OptionType.STRING, "rainmaker", l.botLocale.cmdProfileRank2Desc.replace("%mode%",l.rules.get("rainmaker").name), false);
        final OptionData splatzones = new OptionData(OptionType.STRING, "splatzones", l.botLocale.cmdProfileRank2Desc.replace("%mode%",l.rules.get("splat_zones").name), false);
        final OptionData towercontrol = new OptionData(OptionType.STRING, "towercontrol", l.botLocale.cmdProfileRank2Desc.replace("%mode%",l.rules.get("tower_control").name), false);
        final OptionData clamblitz = new OptionData(OptionType.STRING, "clamblitz", l.botLocale.cmdProfileRank2Desc.replace("%mode%",l.rules.get("clam_blitz").name), false);
        final OptionData salmonTitle = new OptionData(OptionType.INTEGER, "salmon-run-title", l.botLocale.cmdProfileSRTitleDesc, false);
        salmonTitle.addChoice(l.botLocale.salmonRunTitleApprentice, 1);
        salmonTitle.addChoice(l.botLocale.salmonRunTitlePartTimer, 2);
        salmonTitle.addChoice(l.botLocale.salmonRunTitleGoGetter, 3);
        salmonTitle.addChoice(l.botLocale.salmonRunTitleOverachiever, 4);
        salmonTitle.addChoice(l.botLocale.salmonRunTitleProfreshional, 5);


        splat1.addOptions(wiiuNNID, wiiuPNID, splatname, splatlevel, rank);
        splat2.addOptions(switchfc, splatlevel, splatname, rainmaker, splatzones, towercontrol, clamblitz, salmonTitle);

        addSubcommands(splat2, splat1);
    }

    @Override
    public boolean requiresManageServer() {
        return false;
    }

    @Override
    public void execute(SlashCommandEvent ev) {
        final Locale lang = Main.translations.get(Main.iface.getServerLang(ev.getGuild().getIdLong()));
        final String subcommandName = ev.getSubcommandName();
        final SplatProfile profile = Main.iface.getSplatoonProfiles(ev.getUser().getIdLong());
        if (subcommandName != null)
            switch (subcommandName) {
                case "splat1":
                    if (ev.getOptions().isEmpty()) {
                        if ((profile.wiiu_nnid != null || profile.wiiu_pnid != null) && (!profile.wiiu_pnid.isBlank() || !profile.wiiu_pnid.isEmpty())) {
                            final EmbedBuilder b = new EmbedBuilder();
                            if (profile.splat1Profile.name != null && !profile.splat1Profile.name.isBlank())
                                b.setTitle(profile.splat1Profile.name + "'s Splatoon 1 Profile");
                            else
                                b.setTitle(ev.getMember().getEffectiveName() + "'s Splatoon 1 Profile");
                            b.addField(lang.botLocale.cmdProfileLevel, profile.splat1Profile.level + "", true);
                            b.addField(lang.botLocale.cmdProfileRank, profile.splat1Profile.rank.toString(), true);
                            String footer = "";
                            if (profile.wiiu_nnid != null && !profile.wiiu_nnid.isBlank())
                                footer += "NNID: " + profile.wiiu_nnid;
                            if (profile.wiiu_nnid != null && !profile.wiiu_nnid.isBlank() && profile.wiiu_pnid != null && !profile.wiiu_pnid.isBlank()) {
                                footer += " | ";
                            }
                            if (profile.wiiu_pnid != null && !profile.wiiu_pnid.isBlank())
                                footer += "PNID: " + profile.wiiu_pnid;
                            b.setFooter(footer);

                            ev.replyEmbeds(b.build()).queue();
                        } else {
                            ev.reply(lang.botLocale.cmdProfileMissingNID).queue();
                        }
                    } else {
                        String msg = "";
                        if (ev.getOption("nintendo-id") != null) {
                            profile.wiiu_nnid = ev.getOption("nintendo-id").getAsString();
                            msg += "Set NNID to " + ev.getOption("nintendo-id").getAsString() + "\n";
                        }
                        if (ev.getOption("pretendo-id") != null) {
                            profile.wiiu_pnid = ev.getOption("pretendo-id").getAsString();
                            msg += "Set PNID to " + ev.getOption("pretendo-id").getAsString() + "\n";
                        }
                        if ((profile.wiiu_nnid != null || profile.wiiu_pnid != null) && (!profile.wiiu_pnid.isBlank() || !profile.wiiu_pnid.isEmpty())) {

                            if (ev.getOption("level") != null) {
                                profile.splat1Profile.level = (Integer.parseInt(ev.getOption("level").getAsString()));
                                msg += lang.botLocale.cmdProfileLevel1Set + profile.splat1Profile.level + "\n";
                            }
                            if (ev.getOption("name") != null) {
                                final String name = ev.getOption("name").getAsString();
                                if (name.length() > 10) {
                                    msg += lang.botLocale.cmdProfileNameErr + "\n";
                                } else {
                                    profile.splat1Profile.name = name;
                                    msg += lang.botLocale.cmdProfileNameSet + name + "\n";
                                }
                            }
                            if (ev.getOption("rank") != null) {
                                try {
                                    final Splat1Profile.Rank rank = new Splat1Profile.Rank(ev.getOption("rank").getAsString());
                                    profile.splat1Profile.rank = rank;
                                    msg += lang.botLocale.cmdProfileS1RankSet.replace("%rank%", profile.splat1Profile.rank.toString()) + "\n";
                                } catch (IllegalArgumentException e) {
                                    msg += lang.botLocale.cmdProfileRankFormatNotValid + "\n";
                                }
                            }

                            Main.iface.updateSplatProfile(profile);
                        } else {
                            msg += lang.botLocale.cmdProfilennidErr;
                        }
                        ev.reply(msg).queue();
                    }
                    break;
                case "splat2":
                    if (ev.getOptions().isEmpty()) {
                        if (profile.switch_fc != -1) {
                            final EmbedBuilder b = new EmbedBuilder();
                            if (profile.splat2Profile.getName() != null && !profile.splat2Profile.getName().isBlank())
                                b.setTitle(profile.splat2Profile.getName() + "'s Splatoon 2 Profile");
                            else
                                b.setTitle(ev.getMember().getEffectiveName() + "'s Splatoon 2 Profile");
                            b.addField(lang.botLocale.cmdProfileLevel, profile.splat2Profile.getLevel(), true);

                            b.addField(lang.botLocale.cmdProfileSRTitle, getSRTitle(profile.splat2Profile.srTitle, lang), true);
                            b.addBlankField(false);
                            b.addField(lang.rules.get("rainmaker").name, profile.splat2Profile.rainmaker.toString(), true);
                            b.addField(lang.rules.get("splat_zones").name, profile.splat2Profile.splatzones.toString(), true);
                            b.addField(lang.rules.get("tower_control").name, profile.splat2Profile.towercontrol.toString(), true);
                            b.addField(lang.rules.get("clam_blitz").name, profile.splat2Profile.clamblitz.toString(), true);
                            String footer = "Switch FC: " + profile.switch_fc;
                            b.setFooter(footer);

                            ev.replyEmbeds(b.build()).queue();
                        } else {
                            ev.reply(lang.botLocale.cmdProfileMissingFC).queue();
                        }
                    } else {
                        String msg = "";
                        if (ev.getOption("switch-fc") != null) {
                            profile.switch_fc = Long.parseLong(ev.getOption("switch-fc").getAsString());
                            msg += lang.botLocale.cmdProfileFCSet + ev.getOption("switch-fc").getAsString() + "\n";
                        }
                        if (profile.switch_fc != -1) {

                            if (ev.getOption("level") != null) {
                                profile.splat2Profile.setLevel(Integer.parseInt(ev.getOption("level").getAsString()));
                                msg += lang.botLocale.cmdProfileLevel2Set + profile.splat2Profile.getLevel() + "\n";
                            }
                            if (ev.getOption("name") != null) {
                                final String name = ev.getOption("name").getAsString();
                                if (name.length() > 10) {
                                    msg += lang.botLocale.cmdProfileNameErr + "\n";
                                } else {
                                    profile.splat2Profile.setName(name);
                                    msg += "Splatoon 2 Name set to " + name + "\n";
                                }
                            }
                            if (ev.getOption("rainmaker") != null) {
                                try {
                                    final Splat2Profile.Rank rank = new Splat2Profile.Rank(ev.getOption("rainmaker").getAsString());
                                    profile.splat2Profile.rainmaker = rank;
                                    msg += lang.botLocale.cmdProfileS2RankSet.replace("%mode%", lang.rules.get("rainmaker").name).replace("%rank%", profile.splat2Profile.rainmaker.toString()) + "\n";
                                } catch (IllegalArgumentException e) {
                                    msg += lang.botLocale.cmdProfileRankFormatNotValid + "\n";
                                }
                            }
                            if (ev.getOption("splatzones") != null) {
                                try {
                                    final Splat2Profile.Rank rank = new Splat2Profile.Rank(ev.getOption("splatzones").getAsString());
                                    profile.splat2Profile.splatzones = rank;
                                    msg += lang.botLocale.cmdProfileS2RankSet.replace("%mode%", lang.rules.get("splat_zones").name).replace("%rank%", profile.splat2Profile.splatzones.toString()) + "\n";
                                } catch (IllegalArgumentException e) {
                                    msg += lang.botLocale.cmdProfileRankFormatNotValid + "\n";
                                }
                            }
                            if (ev.getOption("towercontrol") != null) {
                                try {
                                    final Splat2Profile.Rank rank = new Splat2Profile.Rank(ev.getOption("towercontrol").getAsString());
                                    profile.splat2Profile.towercontrol = rank;
                                    msg += lang.botLocale.cmdProfileS2RankSet.replace("%mode%", lang.rules.get("tower_control").name).replace("%rank%", profile.splat2Profile.towercontrol.toString()) + "\n";
                                } catch (IllegalArgumentException e) {
                                    msg += lang.botLocale.cmdProfileRankFormatNotValid + "\n";
                                }
                            }
                            if (ev.getOption("clamblitz") != null) {
                                try {
                                    final Splat2Profile.Rank rank = new Splat2Profile.Rank(ev.getOption("clamblitz").getAsString());
                                    profile.splat2Profile.clamblitz = rank;
                                    msg += lang.botLocale.cmdProfileS2RankSet.replace("%mode%", lang.rules.get("clam_blitz").name).replace("%rank%", profile.splat2Profile.clamblitz.toString()) + "\n";
                                } catch (IllegalArgumentException e) {
                                    msg += lang.botLocale.cmdProfileRankFormatNotValid + "\n";
                                }
                            }
                            if (ev.getOption("salmon-run-title") != null) {
                                profile.splat2Profile.srTitle = Integer.parseInt(ev.getOption("salmon-run-title").getAsString());
                                msg += lang.botLocale.cmdProfileS2SalmonSet.replace("%title%", getSRTitle(profile.splat2Profile.srTitle, lang)) + "\n";

                            }

                            Main.iface.updateSplatProfile(profile);
                        } else {
                            msg += lang.botLocale.cmdProfilefcErr;
                        }
                        ev.reply(msg).queue();
                    }
                    break;
                default:
                    ev.reply("Unknown subcommand, report to developer!").queue(); //Should never be shown at all
                    break;
            }
    }

    private String getSRTitle(int title, Locale lang) {
        String srTitle = lang.botLocale.salmonRunTitleUnset;
        switch (title) {
            case 1:
                srTitle = lang.botLocale.salmonRunTitleApprentice;
                break;
            case 2:
                srTitle = lang.botLocale.salmonRunTitlePartTimer;
                break;
            case 3:
                srTitle = lang.botLocale.salmonRunTitleGoGetter;
                break;
            case 4:
                srTitle = lang.botLocale.salmonRunTitleOverachiever;
                break;
            case 5:
                srTitle = lang.botLocale.salmonRunTitleProfreshional;
                break;

        }
        return srTitle;
    }
}
