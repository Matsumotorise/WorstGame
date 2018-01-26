package game.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assets {

  //////////////////TILES/////////////////////////////
  private static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
  public static List<List<Animator>> playerFrame;
  public static List<Animator> F137;
  public static BufferedImage[] btnStart;
  //ArrayList vs LinkedList?
  //More CPU vs Memory consumption
  public static BufferedImage dirt, grass, stone, tree1;

  public static void init() {
    //SpriteLoaders
    SpriteLoader sheet = new SpriteLoader("/textures/sheet.png");
    SpriteLoader tileSet = new SpriteLoader("/textures/Tileset.png");
    SpriteLoader mewWalking = new SpriteLoader("/textures/Protagmew.png");
    SpriteLoader mewRunning = new SpriteLoader("/textures/MewRun.png");
    SpriteLoader OneThreeSevenWalking = new SpriteLoader("/textures/137.png");

    // Intervals for 395x395 png
    int xInterval = 98;
    int yInterval = 98;

    ////////////////////Player walking animations////////////////////
    int characterSpriteWidth = 98, characterSpriteHeight = 98;
    int characterWXOffset = 0, characterWYOffset = 0;

    BufferedImage[][] playerW = new BufferedImage[][]{{////////////////////Up
        mewWalking.crop(characterWXOffset, characterWYOffset + yInterval * 3, characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight)}, { //////////////////Down
        mewWalking.crop(characterWXOffset, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval * 2, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval * 3, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight)},
        {/////////////////Left
            mewWalking.crop(characterWXOffset, characterWYOffset + yInterval, characterSpriteWidth,
                characterSpriteHeight),
            mewWalking.crop(characterWXOffset + xInterval, characterWYOffset + yInterval,
                characterSpriteWidth,
                characterSpriteHeight),
            mewWalking.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval,
                characterSpriteWidth,
                characterSpriteHeight),
            mewWalking.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval,
                characterSpriteWidth,
                characterSpriteHeight)}, {/////////////Right
        mewWalking.crop(characterWXOffset, characterWYOffset + yInterval * 2, characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        mewWalking.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight)}};

    //////////////////////Player Running Animations/////////////////////////////
    BufferedImage[][] playerR = new BufferedImage[][]{{//Up
        mewRunning.crop(characterWXOffset, characterWYOffset + yInterval * 3, characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight)}, { //Down
        mewRunning.crop(characterWXOffset, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval * 2, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval * 3, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight)},
        {//Left
            mewRunning.crop(characterWXOffset, characterWYOffset + yInterval, characterSpriteWidth,
                characterSpriteHeight),
            mewRunning.crop(characterWXOffset + xInterval, characterWYOffset + yInterval,
                characterSpriteWidth,
                characterSpriteHeight),
            mewRunning.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval,
                characterSpriteWidth,
                characterSpriteHeight),
            mewRunning.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval,
                characterSpriteWidth,
                characterSpriteHeight)}, {//Right
        mewRunning.crop(characterWXOffset, characterWYOffset + yInterval * 2, characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        mewRunning.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight)}};

    ///////////////////////////////137 Walking///////////////////////////////
    BufferedImage[][] w137 = new BufferedImage[][]{{//Up
        OneThreeSevenWalking.crop(characterWXOffset, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval, characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 2,
            characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 3,
            characterWYOffset + yInterval * 3,
            characterSpriteWidth,
            characterSpriteHeight)}, { //Down
        OneThreeSevenWalking.crop(characterWXOffset, characterWYOffset, characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval, characterWYOffset,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 2, characterWYOffset,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 3, characterWYOffset,
            characterSpriteWidth,
            characterSpriteHeight)}, {//Left
        OneThreeSevenWalking.crop(characterWXOffset, characterWYOffset + yInterval,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval, characterWYOffset + yInterval,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 2, characterWYOffset + yInterval,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 3, characterWYOffset + yInterval,
            characterSpriteWidth,
            characterSpriteHeight)}, {//Right
        OneThreeSevenWalking.crop(characterWXOffset, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval, characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 2,
            characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight),
        OneThreeSevenWalking.crop(characterWXOffset + xInterval * 3,
            characterWYOffset + yInterval * 2,
            characterSpriteWidth,
            characterSpriteHeight)}};

    /////////////////////Initializing frames///////////////////////////////
    ArrayList<Animator> playerWFrame = new ArrayList<>(Arrays
        .asList(new Animator(400, playerW[0]), new Animator(400, playerW[1]),
            new Animator(400, playerW[2]),
            new Animator(400, playerW[3])));

    ArrayList<Animator> playerRFrame = new ArrayList<>(Arrays
        .asList(new Animator(200, playerR[0]), new Animator(200, playerR[1]),
            new Animator(200, playerR[2]),
            new Animator(200, playerR[3])));

    playerFrame = new ArrayList<>(Arrays.asList(playerWFrame, playerRFrame));

    F137 = new ArrayList<>(
        Arrays.asList((new Animator(500, w137[0])), (new Animator(500, w137[1])),
            (new Animator(500, w137[2])),
            (new Animator(500, w137[3]))));

    /////////////////////Basic Texture/////////////////////////////////////////
    tree1 = tileSet.crop(2, 2080, 92, 129);
    dirt = sheet.crop(TILE_WIDTH, 0, TILE_WIDTH, TILE_HEIGHT);
    grass = sheet.crop(2 * TILE_WIDTH, 0, TILE_WIDTH, TILE_HEIGHT);
    stone = sheet.crop(3 * TILE_WIDTH, 0, TILE_WIDTH, TILE_HEIGHT);

    ////////////////Button Start/////////////////////
    btnStart = new BufferedImage[]{sheet.crop(6 * TILE_WIDTH, 0, TILE_WIDTH * 2, TILE_HEIGHT),
        sheet.crop(6 * TILE_WIDTH, TILE_HEIGHT, TILE_WIDTH * 2, TILE_HEIGHT)};

  }
}

