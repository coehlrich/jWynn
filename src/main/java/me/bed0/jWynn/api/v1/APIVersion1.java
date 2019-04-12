package me.bed0.jWynn.api.v1;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.v1.item.ItemCategory;
import me.bed0.jWynn.exceptions.APIRequestException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class APIVersion1 extends APIMidpoint {

    private WynncraftAPI api;

    public APIVersion1(WynncraftAPI api) {
        v2 = false;
        this.api = api;
    }

    public APIV1TerritoryList territoryList() {
        return new APIV1TerritoryList(api.getConfig().getBaseURL() + "public_api.php?action=territoryList", this);
    }

    public APIV1GuildList guildList() {
        return new APIV1GuildList(api.getConfig().getBaseURL() + "public_api.php?action=guildList", this);
    }

    public APIV1GuildStats guildStats(String guildName) {
        try {
            return new APIV1GuildStats(api.getConfig().getBaseURL() + "public_api.php?action=guildStats&command=" + URLEncoder.encode(guildName, "UTF-8"), this);
        } catch (UnsupportedEncodingException ex) {
            throw new APIRequestException(ex);
        }
    }

    public APIV1ItemDB itemDBByCategory(ItemCategory category) {
        return new APIV1ItemDB(api.getConfig().getBaseURL() + "public_api.php?action=itemDB&category=" + category.toString().toLowerCase(), this);
    }

    public APIV1ItemDB itemDBSearch(String search) {
        try {
            return new APIV1ItemDB(api.getConfig().getBaseURL() + "public_api.php?action=itemDB&search=" + URLEncoder.encode(search, "UTF-8"), this);
        } catch (UnsupportedEncodingException ex) {
            throw new APIRequestException(ex);
        }
    }

    public APIV1StatsSearch statsSearch(String search) {
        try {
            return new APIV1StatsSearch(api.getConfig().getBaseURL() + "public_api.php?action=statsSearch&search=" + URLEncoder.encode(search, "UTF-8"), this);
        } catch (UnsupportedEncodingException ex) {
            throw new APIRequestException(ex);
        }
    }

    public APIV1OnlinePlayerSum onlinePlayerSum() {
        return new APIV1OnlinePlayerSum(api.getConfig().getBaseURL() + "public_api.php?action=onlinePlayersSum", this);
    }

    @Deprecated
    public APIV1OnlinePlayers onlinePlayers() {
        return new APIV1OnlinePlayers(api.getConfig().getBaseURL() + "public_api.php?action=onlinePlayers", this);
    }
}
