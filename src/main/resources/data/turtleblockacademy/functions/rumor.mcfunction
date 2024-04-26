#professions/cartographer/rumor

execute store result score @s rumor_temp1 run time query gametime
scoreboard players operation @s rumor_temp1 %= $9 rumor_const

execute if score @s rumor_temp1 matches 0 store result score @s rumor_temp2 run locate structure #rumor:treasure_poi
execute if score @s rumor_temp1 matches 1 store result score @s rumor_temp2 run locate structure #rumor:desert_poi
execute if score @s rumor_temp1 matches 2 store result score @s rumor_temp2 run locate structure #rumor:jungle_poi
execute if score @s rumor_temp1 matches 3 store result score @s rumor_temp2 run locate structure #rumor:underground_poi
execute if score @s rumor_temp1 matches 4 store result score @s rumor_temp2 run locate structure #rumor:pillager_poi
execute if score @s rumor_temp1 matches 5 store result score @s rumor_temp2 run locate structure #rumor:ocean_poi
execute if score @s rumor_temp1 matches 6 store result score @s rumor_temp2 run locate structure #rumor:misc_poi
execute if score @s rumor_temp1 matches 7 store result score @s rumor_temp2 run locate structure #rumor:witch_sighting
execute if score @s rumor_temp1 matches 8 store result score @s rumor_temp2 run locate structure #rumor:settlement

execute if score @s rumor_temp1 matches 0 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about "},{"text":"some buried treasure","color":"yellow"},{"text":" in this area ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 1 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about "},{"text":"something interesting in the desert","color":"yellow"},{"text":" ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 2 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about "},{"text":"something interesting in the jungle","color":"yellow"},{"text":" ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 3 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about "},{"text":"something underground","color":"yellow"},{"text":" in this area ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 4 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about a "},{"text":"possible pillager settlement","color":"yellow"},{"text":" in this area ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 5 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about "},{"text":"something seaward","color":"yellow"},{"text":" ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 6 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about a "},{"text":"something evil","color":"yellow"},{"text":" ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":") so be careful if you go."}]
execute if score @s rumor_temp1 matches 7 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about "},{"text":"sightings of possible witches","color":"yellow"},{"text":" in this area ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]
execute if score @s rumor_temp1 matches 8 run tellraw @a[distance=..4] ["",{"text":"["},{"selector":"@s"},{"text":"] I've heard rumors about a "},{"text":"settlement","color":"yellow"},{"text":" in this area ("},{"score":{"name":"@s","objective":"rumor_temp2"},"color":"yellow"},{"text":" blocks away","color":"yellow"},{"text":")."}]

scoreboard players reset @s rumor_temp1
scoreboard players reset @s rumor_temp2

scoreboard players add @s rumor_cooldown 96000