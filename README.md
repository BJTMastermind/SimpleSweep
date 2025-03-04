# Simple Sweep
Simple Minecraft mod that removes the sweep attack unless the weapon is enchanted with a sweeping enchantment (i.e. Sweeping Edge).

## Config
`whitelist` If this has entries, only the items listed will have their sweep attack disabled. Entries should be in the form of a namespaced id, i.e. 'minecraft:diamond_sword'

`blacklist` _Only used if whitelist is empty._ Entries in this list will be exluded from having their sweep attack disabled. Entries should be in the form of a namespaced id, i.e. 'minecraft:diamond_sword'

`onlyCrouch` Set to true to require the player to be crouching to do the sweep attack, regardless of if the sword has the Sweeping Edge enchantment.

To find the *namespaced id* of an item, press _F3 + H_ to activate advanced tooltips. Then, hover over any item you wish to see its namespaced id.

## Issue Reporting
To report an issue, conflict, or feature request, go ahead and use the [Issues](https://github.com/BJTMastermind/SimpleSweep/issues) tab above.