<template>
    <div class="ui fluid container">
        <h2 class="ui header">
            {{ table.title }}
        </h2>
        <table class="ui table">
            <thead v-if="props.viewColumns == 'true'">
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
    </div>
    <div class="ui hidden divider"/>
    <div class="ui button" @click="listTable = true">
        Выбор таблицы
    </div>
    <TableListWindow v-if="listTable" @quit="listTable = false"/>
</template>

<script setup>
import { ref } from 'vue';
import TableListWindow from '../windows/TableListWindow.vue';

const props = defineProps({
    tableId: {
        type: Number,
        required: true
    },
    viewColumns: {
        type: String,
        required: true
    }
})
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
const listTable = ref(false)

table.value.id = props.tableId+0
</script>