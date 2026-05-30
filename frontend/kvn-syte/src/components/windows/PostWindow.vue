<template>
    <div class="back">
        <div class="window">
            <div class="ui text container segment">
                <h2 class="ui header">
                     Таблица test!!! {{ props.tableId }}
                </h2>
                <table class="ui table">
                    <thead>
                        <tr>
                            <th v-for="col in table.columns" :key="col.pos">
                                {{ col.name }}
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="row in table.rows" :key="row.pos">
                            <td v-for="el in row.elements" :key="el.pos">
                                <p> {{ el }}</p>
                            </td>
                        </tr>
                    </tbody>
                </table>
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
    tableId: {
        required: true
    }
})

//const emit = defineEmits(['quit', 'edit', 'block', 'delete'])

// Заглушка-таблица
const table = ref({
    title: 'С 23 февраля!',
    data: '23.02.2026',
    blocks: [
        {pos:0, type:"text", data :["Дорогие мужчины КВН — участники, редакторы, ведущие, руководители команд и наши зрители! Поздравляем вас с 23 февраля!",
        "Желаем сил, характера, надёжной команды рядом и побед — на сцене и за её пределами. Спасибо, что делаете КВН ярче, смелее и смешнее! С праздником!"]},
        {pos:1, type:"photo", data:["https://sun9-24.userapi.com/s/v1/ig2/f8H3AIGcdX1uvs0VmSYqevznAjgrXZx5Y9D9zJmmoyPLkLMXMqgb9MMcZaB3cmIr-wtlkL4wxQXlBX1-LgtXWodA.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-41.userapi.com/s/v1/ig2/LJrwnkXF_fQvJ80DCTtHX3fERt209-5Y4NJ2a-vULG_Q_oq4cE1bdujFyaisVOWDiQhSiaCjuAeLSDy1IJ2PRBhh.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-23.userapi.com/s/v1/ig2/XmOXw_--LS5EOVGoG-i00REt_Xrrd3Zj3qY85VHp-AZD7Xr2PNo9ZEoUfVspRWuh_V2JgIlbBaAQXtMz0UzvFUAk.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0",
        "https://sun9-80.userapi.com/s/v1/ig2/cxa7eMMZPtfQt80MCjO6mLhauUnNKNsI7ip-BFzK-hXDx4fY1y8EDcenG28r3HaGGX36oZMda6xU7uPrQxPCwOnz.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x427,720x480,1080x720,1280x853,1440x960,2560x1707&from=bu&cs=2560x0"]}
    ]
})

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