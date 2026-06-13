<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"></i>
                </div>
            </div>
            <div class="ui text container segment" style="width: 100%;">
                <h2 class="ui header">
                    Стиль #{{ props.styleId }}
                </h2>
                <div class="field" align="left">
                    <p> Название: {{ style.name }}</p>
                    <p> Роль стиля: {{ style.role }}</p>
                    <p> Шрифт: {{ style.fontname }}</p>
                    <p> Размер шрифта: {{ style.fontsize }}</p>
                </div>
                <h4 class="ui header">
                    Цвета
                </h4>
                <div v-for="(col, i) in style.colors" :key="i" align="left">
                    #{{ i }}
                    <div :style="{width: diam + 'px', height: diam + 'px', borderRadius: diam / 2 + 'px', backgroundColor: col}"/>
                    {{ col }}
                </div>
                <div class="ui clearing divider"></div>
                <button class = "ui primary button" @click="$emit('edit')">Открыть в редакторе</button>
                <button class = "ui button" @click="$emit('quit')">Выйти</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const props = defineProps({
    styleId: {
        required: true
    }
})

// Заглушка-стиль
const style = ref({
    name: "Test",
    role: "dark-theme",
    fontname: "Arial",
    fontsize: "16pt",
    colors: ["rgb(0, 0, 0)", "rgb(255, 255, 0)", "rgb(255, 0, 255)"]
})

const diam = ref(50)
</script>

<style scoped>
.window {
  position: fixed;
  z-index: 999;
  top: 15%;
  left: 30%;
  width: 40%;
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
}

.back {
    position: fixed;
    z-index: 998;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}
</style>