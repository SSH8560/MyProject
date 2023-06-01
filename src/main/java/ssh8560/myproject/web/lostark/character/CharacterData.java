package ssh8560.myproject.web.lostark.character;

public enum CharacterData {
    EQUIPMENT("equipment"),
    AVATAR("avatars"),
    COMBAT_SKILL("combat-skills"),
    ENGRAVING("engravings"),
    CARD("cards"),
    GEM("gems");

    private final String filter;
    CharacterData(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
