package com.elh.games.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.elh.games.Controllers.GameController;
import com.elh.games.GoalGame;

/**
 * Created by Loik on 19/09/2015.
 */
public class GameScreen implements Screen {

    private GoalGame game;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    SpriteBatch batch;
    Texture img;

    public GameScreen(GoalGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        TmxMapLoader loader = new TmxMapLoader();//création du loader de carte
        map = loader.load("maps/field.tmx");//chargement de la carte
        renderer = new OrthogonalTiledMapRenderer(map);//création du renderer

        camera = new OrthographicCamera(1080, 1920);//taille du viewPort
        camera.position.set(540,960, 0);//position de la caméra dansle monde 2D...centrée sur la carte (640*640) !!


        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        GameController game = new GameController();
    }

    @Override
    public void render(float delta) {
/*        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();//rendu de la carte
        camera.update();//important sinon pas de prise en compte des input camera !!
        renderer.setView(camera);//on indique la caméra utilisée pour coupler les systèmes de coordonnées*/

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
