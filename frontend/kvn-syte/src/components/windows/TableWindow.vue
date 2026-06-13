<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"></i>
                </div>
            </div>
            <div class="ui text container segment" style="width: 100%;">
                <h2 class="ui header" v-if="props.tableId != -1">
                     Таблица #{{ props.tableId }}
                </h2>
                <h2 class="ui header" v-else>
                     Таблица {{ table.title }}
                </h2>
                <table class="ui table">
                    <thead>
                        <tr>
                            <th v-for="(col, i) in table.columns" :key="i">
                                {{ col }}
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(row, i) in table.rows" :key="i">
                            <td v-for="(el, j) in row" :key="j">
                                <p> {{ el }}</p>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="ui clearing divider"></div>
                <button class = "ui primary button" @click="$emit('edit')" v-if="props.tableId != -1">Открыть в редакторе</button>
                <button class = "ui button" @click="$emit('quit')">Выйти</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const props = defineProps({
    tableId: {
        type: Number,
        required: true
    },
    table: {
        type: Object,
        required: true
    }
})

//const emit = defineEmits(['quit', 'edit', 'block', 'delete'])

// Заглушка-таблица
const table = ref({
    title: "Abacaba",
    columns: ["ABC", "QWE", "ASD", "ZXC"],
    rows: [
        [1, 2, "pop", "1a2"],
        [8, 21, "asd", "j54"],
        [2, 11, "zass", "fgh5"],
        [3, 9, "prpr", "fw3f"],
        [5, 7, "vvc", "1234f"]
    ]
})

if(props.table){
    table.value = JSON.parse(JSON.stringify(props.table))
}

</script>

<style scoped>
.window {
  position: fixed;
  z-index: 999;
  top: 15%;
  left: 25%;
  width: 50%;
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