# Deplete Tell

Deplete Tell shows the durability of any damageable item directly in its tooltip, so you always know how much life your gear has left at a glance.

## Features

### Always Show

Controls whether durability is always displayed in the tooltip.

- **Default:** `false` — durability is only shown once an item is damaged
- Set to `true` to always show durability, even on undamaged items

**Comparison**

|                                                    Always Show: `true`                                                     |                                                       Always Show: `false` (undamaged)                                                        |                                                      Always Show: `false` (damaged)                                                       |
|:--------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------:|
| ![always_true](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_number.png) | ![always_false_undamaged](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/always_show_false_undamaged.png) | ![always_false_damaged](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/always_show_false_damaged.png) |

### Blacklist

Exclude specific items from durability tooltips.

![blacklist](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/blacklist_demo.gif)

### Display Style

Choose how durability is displayed. Three styles are available:

- `BAR`
- `PERCENTAGE`
- `NUMBER` *(default)*

**Preview**

|                                                          Percentage                                                           |                                                       Bar                                                       |                                                        Number                                                         |
|:-----------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|
| ![percentage](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_percentage.png) | ![bar](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_bar.png) | ![number](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_number.png) |

## Required Dependencies

| Mod        |                    Modrinth                     |                              CurseForge                               |
|------------|:-----------------------------------------------:|:---------------------------------------------------------------------:|
| Fabric API | [Modrinth](https://modrinth.com/mod/fabric-api) | [CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-api) |
| ReLib      |   [Modrinth](https://modrinth.com/mod/relib)    |   [CurseForge](https://www.curseforge.com/minecraft/mc-mods/relib)    |

## Configuration

For a full configuration guide, see the [Wiki](https://github.com/TheSmoothRere/DepleteTell/wiki/Configuration).

## Support

If you find this mod useful, consider supporting development via [Ko-fi](https://ko-fi.com/thesmoothrere) or [PayPal](https://paypal.me/thesmoothrere).