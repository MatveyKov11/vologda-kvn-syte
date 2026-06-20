<template>
    <div class="ui hidden divider" v-if="!props.isEdit"/>
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
    <div class="ui hidden divider" v-if="props.isEdit"/>
    <div class="ui button" @click="listTable = true" v-if="props.isEdit">
        Выбор таблицы
    </div>
    <div class="ui hidden divider" v-else/>
    <TableListWindow v-if="listTable" @quit="listTable = false" @select="(t) => {changeTable(t); listTable = false}"/>
</template>

<script setup>
import { ref } from 'vue';
import TableListWindow from '../windows/lists/TableListWindow.vue';

const props = defineProps({
    tableId: {
        type: Number,
        required: true
    },
    viewColumns: {
        type: String,
        required: true
    },
    isEdit: {
        type: Boolean,
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

function changeTable(id){
    table.value.id = id
}

changeTable(props.tableId)
</script>