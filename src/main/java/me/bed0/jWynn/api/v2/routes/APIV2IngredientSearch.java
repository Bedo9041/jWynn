package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.common.WynncraftIdentification;
import me.bed0.jWynn.api.common.WynncraftProfession;
import me.bed0.jWynn.api.v2.endpoints.*;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class APIV2IngredientSearch {

    private APIMidpoint midpoint;
    private WynncraftAPI api;

    APIV2IngredientSearch(APIMidpoint midpoint, WynncraftAPI api) {
        this.midpoint = midpoint;
        this.api = api;
    }

    @CheckReturnValue
    public APIV2IngredientRequest skillsOr(WynncraftProfession... professions) {
        StringBuilder builder = new StringBuilder("v2/ingredient/search/skills/%5E");
        for (WynncraftProfession profession : professions) {
            builder.append(profession).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + builder.toString(), midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientRequest skillsAnd(WynncraftProfession... professions) {
        StringBuilder builder = new StringBuilder("v2/ingredient/search/skills/&");
        for (WynncraftProfession profession : professions) {
            builder.append(profession).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + builder.toString(), midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientRequest name(String name) {
        try {
            return new APIV2IngredientRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/name/" + URLEncoder.encode(name, "UTF-8"), midpoint);
        } catch (UnsupportedEncodingException ex) {
            throw new APIRequestException(ex);
        }
    }

    @CheckReturnValue
    public APIV2IngredientRequest tier(int tier) {
        if (tier > 3 || tier < 0)
            throw new APIRequestException("V2 Ingredient Search: Tier specified was out of valid range (0-3)");
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/tier/" + tier, midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientRequest level(int level) {
        if (level > 130 || level < 0)
            throw new APIRequestException("V2 Ingredient Search: Level specified was out of valid range (1-130)");
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/level/" + level, midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add identifications to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientIdentificationRequest#withIdentification(WynncraftIdentification, Integer, Integer)}
     */
    @CheckReturnValue
    public APIV2IngredientIdentificationRequest identificationsOr() {
        return new APIV2IngredientIdentificationRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/identifications/%5E", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add identifications to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientIdentificationRequest#withIdentification(WynncraftIdentification, Integer, Integer)}
     */
    @CheckReturnValue
    public APIV2IngredientIdentificationRequest identificationsAnd() {
        return new APIV2IngredientIdentificationRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/identifications/&", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add sprite details to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientSpriteRequest#withDamage(int)} and
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientSpriteRequest#withId(int)}
     */
    @CheckReturnValue
    public APIV2IngredientSpriteRequest spriteOr() {
        return new APIV2IngredientSpriteRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/sprite/%5E", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add sprite details to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientSpriteRequest#withDamage(int)}, and
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientSpriteRequest#withId(int)}
     */
    @CheckReturnValue
    public APIV2IngredientSpriteRequest spriteAnd() {
        return new APIV2IngredientSpriteRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/sprite/&", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add identifications to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withDurability(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withAgility(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withDexterity(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withDefence(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withIntelligence(int)}, and
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withStrength(int)}
     */
    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest itemOnlyIDsOr() {
        return new APIV2IngredientItemOnlyIDsRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/itemOnlyIDs/%5E", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add identifications to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withDurability(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withAgility(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withDexterity(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withDefence(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withIntelligence(int)}, and
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientItemOnlyIDsRequest#withStrength(int)}
     */
    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest itemOnlyIDsAnd() {
        return new APIV2IngredientItemOnlyIDsRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/itemOnlyIDs/&", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add identifications to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientConsumableOnlyIDsRequest#withDuration(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientConsumableOnlyIDsRequest#withCharges(int)},
     */
    @CheckReturnValue
    public APIV2IngredientConsumableOnlyIDsRequest consumableOnlyIDsOr() {
        return new APIV2IngredientConsumableOnlyIDsRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/consumableOnlyIDs/%5E", midpoint);
    }

    /**
     * Unlike other requests, this request acts as a request builder, you add add identifications to the search using
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientConsumableOnlyIDsRequest#withDuration(int)},
     * {@link me.bed0.jWynn.api.v2.endpoints.APIV2IngredientConsumableOnlyIDsRequest#withCharges(int)},
     */
    @CheckReturnValue
    public APIV2IngredientConsumableOnlyIDsRequest consumableOnlyIDsAnd() {
        return new APIV2IngredientConsumableOnlyIDsRequest(api.getConfig().getBaseURL() + "v2/ingredient/search/consumableOnlyIDs/&", midpoint);
    }
}
