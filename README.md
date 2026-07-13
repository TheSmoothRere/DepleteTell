# Deplete Tell

## Description
Deplete Tell is a mod to show you durability of whatever item that can be damaged as a tooltip.

## Config
Here is the following config to fit your preference.
You can find the config file under relative path where of your instance installed then under `config/depletetell.json`.

#### Default Config
```json
{
  "alwaysShow": false,
  "blackListedItem": [],
  "durabilityStyle": "NUMBER"
}
```

### Always Show
Whether to always show the durability. Default is `false` so it only show the durability when the item is damaged.

#### Image Comparison
**always show true**

![always_true](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_number.png)

**always show false undamaged**

![always_false_undamaged](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/always_show_false_undamaged.png)

**always show false damaged**

![always_false_damaged](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/always_show_false_damaged.png)

### Blacklist

![blacklist](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/blacklist_demo.gif)

### Display Style
It has 3 different display styles `BAR`, `PERCENTAGE`, `NUMBER`, the default value is `NUMBER`

#### Preview Image

**Display type Percentage**

![percentage](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_percentage.png)

**Display type Bar**

![bar](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_bar.png)


**Display type Number**

![number](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/display_type_number.png)