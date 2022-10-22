package com.github.teamfusion.rottencreatures.common.worldgen;

import com.github.teamfusion.platform.common.worldgen.BiomeManager;
import com.github.teamfusion.rottencreatures.common.entities.Burned;
import com.github.teamfusion.rottencreatures.common.entities.DeadBeard;
import com.github.teamfusion.rottencreatures.common.entities.Frostbitten;
import com.github.teamfusion.rottencreatures.common.entities.GlacialHunter;
import com.github.teamfusion.rottencreatures.common.entities.Mummy;
import com.github.teamfusion.rottencreatures.common.entities.Swampy;
import com.github.teamfusion.rottencreatures.common.entities.UndeadMiner;
import com.github.teamfusion.rottencreatures.common.registries.RCEntityTypes;
import com.github.teamfusion.rottencreatures.mixin.access.SpawnPlacementsAccessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;

public class WorldGeneration {
    public static void setup() {
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.BURNED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Burned::checkBurnedSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.FROSTBITTEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Frostbitten::checkFrostbittenSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.SWAMPY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Swampy::checkSwampySpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.UNDEAD_MINER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, UndeadMiner::checkUndeadMinerSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.GLACIAL_HUNTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GlacialHunter::checkGlacialHunterSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.MUMMY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mummy::checkMummySpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.SCARAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.FLYING_SCARAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.DEAD_BEARD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DeadBeard::checkDeadBeardSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.ZOMBIE_LACKEY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.SKELETON_LACKEY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.IMMORTAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacementsAccessor.callRegister(RCEntityTypes.ZAP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        BiomeManager.add((writer, biome) -> {
            if (biome.is(Biomes.NETHER_WASTES)) {
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.BURNED.get(), 20, 4, 4);
            }

            if (biome.is(BiomeTags.HAS_IGLOO) || biome.is(Biome.BiomeCategory.ICY)) {
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.FROSTBITTEN.get(), 80, 4, 4);
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.GLACIAL_HUNTER.get(), 20, 1, 3);
            }

            if (biome.is(BiomeTags.HAS_RUINED_PORTAL_SWAMP) || biome.is(Biome.BiomeCategory.SWAMP)) {
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.SWAMPY.get(), 80, 4, 4);
            }

            if (biome.is(BiomeTags.HAS_STRONGHOLD) || (!biome.is(Biome.BiomeCategory.NETHER) && !biome.is(Biome.BiomeCategory.THEEND) && !biome.is(Biome.BiomeCategory.NONE) && !biome.is(Biome.BiomeCategory.MUSHROOM))) {
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.UNDEAD_MINER.get(), 20, 1, 4);
            }

            if (biome.is(BiomeTags.HAS_DESERT_PYRAMID) || biome.is(Biome.BiomeCategory.DESERT)) {
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.MUMMY.get(), 20, 1, 3);
            }

            if (biome.is(BiomeTags.HAS_SHIPWRECK_BEACHED) || biome.is(Biome.BiomeCategory.BEACH)) {
                writer.addSpawn(MobCategory.MONSTER, RCEntityTypes.DEAD_BEARD.get(), 10, 1, 1);
            }
        });
    }
}