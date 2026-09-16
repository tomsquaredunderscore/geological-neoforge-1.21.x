package net.tomsquared.geological.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class FluffParticle extends TextureSheetParticle {
    private float rotSpeed;
    private int ticksOnGround = 0;

    protected FluffParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z);

        this.xd = xSpeed * 0.35F;
        this.yd = ySpeed * 0.35F;
        this.zd = zSpeed * 0.35F;

        this.quadSize *= 0.3F + level.random.nextFloat() * 0.8F;
        this.lifetime = 80 + level.random.nextInt(40);
        this.gravity = 0.15F;
        this.friction = 0.94F;

        this.roll = level.random.nextFloat() * ((float)Math.PI * 2F);
        this.oRoll = this.roll;
        this.rotSpeed = (level.random.nextFloat() - 0.5F) * 0.05F;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.oRoll = this.roll;

        super.tick();

        if (!this.onGround) {
            this.roll += this.rotSpeed;
        }

        if (this.age > this.lifetime - 20) {
            this.alpha = (float)(this.lifetime - this.age) / 20.0F;
        }

        if (this.onGround) {
            this.xd = 0;
            this.zd = 0;
            this.yd = 0;
            this.gravity = 0.0F;
            this.rotSpeed = 0.0F;

            ticksOnGround++;
            if (ticksOnGround > 30 && this.lifetime - this.age > 20) {
                this.lifetime = this.age + 20;
            }
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FluffParticle particle = new FluffParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}