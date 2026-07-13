# Deplete Tell

## Description
Deplete Tell is a mod to show you durability of whatever item that can be damaged as a tooltip.

## Config
Here is the following config to fit your preference.
You can find the config file under reative path where of your instance installed then under `config/depletetell.json`.

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

[//]: # comparison image will go here()

#### Example Config
Set to `true` to always show the durability
```json
{
  "alwaysShow": true,
  "blackListedItem": [],
  "durabilityStyle": "NUMBER"
}
```

### Blacklist
You can add `namespace:item_name` to prevent item to show durability.<br>
![blacklist](https://raw.githubusercontent.com/TheSmoothRere/DepleteTell/refs/heads/main/assets/blacklist_demo.gif)

### Display Style
It has 3 different display styles `BAR`, `PERCENTAGE`, `NUMBER`, the default value is `NUMBER`

#### Preview Image

**PERCENTAGE**


**BAR**


**NUMBER**

#### Example Config
Set to `true` to always show the durability
```json
{
  "alwaysShow": true,
  "blackListedItem": [
    "minecraft:netherite_shovel"
  ],
  "durabilityStyle": "PERCENTAGE"
}
```
