$(document).on('change', '.btn-file :file', function() {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
});

$(document).ready(function() {
    $('.btn-file :file').on('fileselect', function(event, numFiles, label) {

        var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' files selected' : label;

        if (input.length) {
            input.val(log);
        } else {
            if (log) alert(log);
        }

    });
});

var WIDTH = $("#sketchPreview").width(),
    HEIGHT = $("#sketchPreview").height();

var renderer, scene, camera, cube, controls;

$(document).ready(function() {
    if (!Detector.webgl) Detector.addGetWebGLMessage();
    var container = document.getElementById("sketchPreview");

    renderer = new THREE.WebGLRenderer();
    renderer.setSize(WIDTH, HEIGHT);
    container.appendChild(renderer.domElement);

    camera = new THREE.PerspectiveCamera(75, WIDTH / HEIGHT, 0.1, 1000);
    scene = new THREE.Scene();

    scene.add(camera);
    camera.position.z = 3;
    camera.position.y = 10;
    camera.lookAt(new THREE.Vector3(0, 0, 0));
    material = new THREE.MeshBasicMaterial({
        color: 0x00ff00,
        wireframe: true
    });
    cube = new THREE.Mesh(new THREE.BoxGeometry(2, 2, 2), material);

    scene.add(cube);

    var grid = new THREE.GridHelper(10, 1);
    scene.add(grid);

    controls = new THREE.OrbitControls(camera, container);
    controls.damping = 0.2;

    requestAnimationFrame(render);
});

function render() {
    requestAnimationFrame(render);

    controls.update();

    renderer.render(scene, camera);
};