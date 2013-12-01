package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.util.FossilFX;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTar extends Block
{
    public BlockTar(int i, Material par2Material)
    {
        super(i, Material.sand);
        this.setCreativeTab(Fossil.tabFBlocks);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.motionX = 0.000000000000000004D;
        entity.motionY = 0.070000000745058064D;
        entity.fallDistance = 0.0F;
        entity.motionZ = 0.000000000000000004D;
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        double var6 = (double)((float)i + random.nextFloat());
        double var8 = (double)j - 0.05D;
        double var10 = (double)((float)k + random.nextFloat());
        FossilFX.spawnParticle("tarBubble", var6, var8 + 1, var10, 0.0D, 0.0D, 0.0D);
//        FossilFX.spawnParticle("flies", i+0.5, j+1.0, k+0.5, 0.0D, 1.5D, 0.0D);
        world.playSound((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), "fossil:tar", random.nextFloat() * 0.3F + 0.1F, random.nextFloat() * 1.0F + 0.0F, false);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        return Fossil.tar.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public boolean renderAsNormalBlock()
    {
        return true;
    }

    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        return true;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Tar"); //adding in a texture, 1.5.1 style!
    }
}
