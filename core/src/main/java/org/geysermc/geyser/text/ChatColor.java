/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.text;

import org.geysermc.mcprotocollib.protocol.data.game.scoreboard.TeamColor;

public class ChatColor {
    public static final String ANSI_RESET = (char) 0x1b + "[0m";

    public static final char ESCAPE = '§';
    public static final String BLACK = ESCAPE + "0";
    public static final String DARK_BLUE = ESCAPE + "1";
    public static final String DARK_GREEN = ESCAPE + "2";
    public static final String DARK_AQUA = ESCAPE + "3";
    public static final String DARK_RED = ESCAPE + "4";
    public static final String DARK_PURPLE = ESCAPE + "5";
    public static final String GOLD = ESCAPE + "6";
    public static final String GRAY = ESCAPE + "7";
    public static final String DARK_GRAY = ESCAPE + "8";
    public static final String BLUE = ESCAPE + "9";
    public static final String GREEN = ESCAPE + "a";
    public static final String AQUA = ESCAPE + "b";
    public static final String RED = ESCAPE + "c";
    public static final String LIGHT_PURPLE = ESCAPE + "d";
    public static final String YELLOW = ESCAPE + "e";
    public static final String WHITE = ESCAPE + "f";
    public static final String OBFUSCATED = ESCAPE + "k";
    public static final String BOLD = ESCAPE + "l";
    public static final String STRIKETHROUGH = ESCAPE + "m";
    public static final String UNDERLINE = ESCAPE + "n";
    public static final String ITALIC = ESCAPE + "o";
    public static final String RESET = ESCAPE + "r";

    /**
     * Convert chat colour codes to terminal colours
     *
     * @param string The text to replace colours for
     *
     * @return A string ready for terminal printing
     */
    public static String toANSI(String string) {
        string = string.replace(BOLD, (char) 0x1b + "[1m");
        string = string.replace(OBFUSCATED, (char) 0x1b + "[5m");
        string = string.replace(ITALIC, (char) 0x1b + "[3m");
        string = string.replace(UNDERLINE, (char) 0x1b + "[4m");
        string = string.replace(STRIKETHROUGH, (char) 0x1b + "[9m");
        string = string.replace(RESET, ANSI_RESET);
        string = string.replace(BLACK, (char) 0x1b + "[0;30m");
        string = string.replace(DARK_BLUE, (char) 0x1b + "[0;34m");
        string = string.replace(DARK_GREEN, (char) 0x1b + "[0;32m");
        string = string.replace(DARK_AQUA, (char) 0x1b + "[0;36m");
        string = string.replace(DARK_RED, (char) 0x1b + "[0;31m");
        string = string.replace(DARK_PURPLE, (char) 0x1b + "[0;35m");
        string = string.replace(GOLD, (char) 0x1b + "[0;33m");
        string = string.replace(GRAY, (char) 0x1b + "[0;37m");
        string = string.replace(DARK_GRAY, (char) 0x1b + "[30;1m");
        string = string.replace(BLUE, (char) 0x1b + "[34;1m");
        string = string.replace(GREEN, (char) 0x1b + "[32;1m");
        string = string.replace(AQUA, (char) 0x1b + "[36;1m");
        string = string.replace(RED, (char) 0x1b + "[31;1m");
        string = string.replace(LIGHT_PURPLE, (char) 0x1b + "[35;1m");
        string = string.replace(YELLOW, (char) 0x1b + "[33;1m");
        string = string.replace(WHITE, (char) 0x1b + "[37;1m");
        return string;
    }

    public static String colorDisplayOrder(int index) {
        // https://bugs.mojang.com/browse/MCPE-41729
        // strikethrough and underlined do not exist on Bedrock
        return switch (index) {
            case 0 -> BLACK;
            case 1 -> DARK_BLUE;
            case 2 -> DARK_GREEN;
            case 3 -> DARK_AQUA;
            case 4 -> DARK_RED;
            case 5 -> DARK_PURPLE;
            case 6 -> GOLD;
            case 7 -> GRAY;
            case 8 -> DARK_GRAY;
            case 9 -> BLUE;
            case 10 -> GREEN;
            case 11 -> AQUA;
            case 12 -> RED;
            case 13 -> LIGHT_PURPLE;
            case 14 -> YELLOW;
            case 15 -> WHITE;
            case 16 -> OBFUSCATED;
            case 17 -> BOLD;
            default -> ITALIC;
        };
    }

    public static String chatColorFor(TeamColor teamColor) {
        // https://bugs.mojang.com/browse/MCPE-41729
        // strikethrough and underlined do not exist on Bedrock
        return switch (teamColor) {
            case BLACK -> BLACK;
            case DARK_BLUE -> DARK_BLUE;
            case DARK_GREEN -> DARK_GREEN;
            case DARK_AQUA -> DARK_AQUA;
            case DARK_RED -> DARK_RED;
            case DARK_PURPLE -> DARK_PURPLE;
            case GOLD -> GOLD;
            case GRAY -> GRAY;
            case DARK_GRAY -> DARK_GRAY;
            case BLUE -> BLUE;
            case GREEN -> GREEN;
            case AQUA -> AQUA;
            case RED -> RED;
            case LIGHT_PURPLE -> LIGHT_PURPLE;
            case YELLOW -> YELLOW;
            case WHITE -> WHITE;
            case OBFUSCATED -> OBFUSCATED;
            case BOLD -> BOLD;
            case STRIKETHROUGH, UNDERLINED -> "";
            case ITALIC -> ITALIC;
            default -> RESET;
        };
    }
}
